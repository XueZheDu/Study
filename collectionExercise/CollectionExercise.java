package cam.gnkjxy.dome1.collectionExercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
课堂练习
1.创建3个Dog(name, age)对象，放入到ArrayList中，赋给List引用
2.用迭代器和增强for循环两种方式来遍历
3.重写Dog的toString方法，输出name和age
 */
public class CollectionExercise {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(new Dog("小黄", 5));
        list.add(new Dog("小白", 3));
        list.add(new Dog("小黑", 4));

        //使用迭代器遍历
        System.out.println("===使用迭代器遍历===");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println(dog);
        }

        //使用增强for循环遍历
        System.out.println("===使用增强for循环遍历===");
        for (Object o : list) {
            System.out.println(o);
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
