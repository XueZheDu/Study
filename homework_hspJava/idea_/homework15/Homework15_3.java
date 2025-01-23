package cam.gnkjxy.homework_hspJava.homework15;

import java.io.*;
import java.util.Properties;

/*
3.编程题
(1)要编写一个dog.properties
name=tom
age=5
color=red
(2)编写Dog类(name,age,color)创建一个dog对象，读取dog.properties 用相应的内容完
成属性初始化，井输出
(3)将创建的Dog对象，序列化到文件dog.dat文件
 */
public class Homework15_3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")),
                properties.getProperty("color"));
        System.out.println("===dog对象信息===");
        System.out.println(dog);
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\dog.dat"));
        oos.writeObject(dog);
        oos.close();
        System.out.println("dog对象序列化完成");
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\dog.dat"));
        Object o = ois.readObject();
        ois.close();
        System.out.println("===反序列化后dog对象信息===");
        System.out.println(o);
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
