package cam.gnkjxy.homework_hspJava.homework1;

/**
 * 1.定义一个Person类(name,age, job),初始化Person对象数组，有3个person对像，
 * 并按照 age 从大到小进行排序，提示，使用冒泡排序
 */

public class Homework1 {
    public static void main(String[] args) {
        Person1_[] person1_ = new Person1_[3];
        person1_[0] = new Person1_("小明", 26, "教师");
        person1_[1] = new Person1_("小王", 28, "厨师");
        person1_[2] = new Person1_("小李", 22, "程序员");

        //输出排序前Person1_的age
        System.out.println("排序前");
        for (int i = 0; i < person1_.length; i++) {
            System.out.println(person1_[i]);
        }

        //冒泡排序
        Person1_ temp_p = null;
        for (int i = 0; i < person1_.length - 1; i++) {
            for (int j = 0; j < person1_.length - 1 - i; j++) {
                if(person1_[j].getAge() < person1_[j+1].getAge()) {
                    temp_p = person1_[j];
                    person1_[j] = person1_[j+1];
                    person1_[j+1] = temp_p;
                }
            }
        }

        //输出排序后Person1_的age
        System.out.println("排序后");
        for (int i = 0; i < person1_.length; i++) {
            System.out.println(person1_[i]);
        }
    }
}

class Person1_ {
    private String name;
    private int age;
    private String job;

    public Person1_(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    //get和set方法
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
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person1_{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}