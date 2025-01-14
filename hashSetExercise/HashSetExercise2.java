package cam.gnkjxy.dome1.hashSetExercise;

import java.util.HashSet;
import java.util.Objects;

/*
HashSet课后练习2
定义一个Employee类，该类包含:private成员属性name，sal，birthday(MyDate类型)，
其中birthday为MyDate类型(属性包括:year, month, day)。要求:
1.创建3个Employee放入HashSet中
2.当name和birthday的值相同时，认为是相同员工不能添加到HashSet集合中
 */
public class HashSetExercise2 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Employee1 employee1_1 = new Employee1("张三", 7000, new MyDate(2003, 5, 6));
        Employee1 employee1_2 = new Employee1("李四", 8000, new MyDate(2002, 10, 6));
        Employee1 employee1_3 = new Employee1("张三", 8000, new MyDate(2003, 5, 6));

        hashSet.add(employee1_1);
        hashSet.add(employee1_2);
        hashSet.add(employee1_3);
    }
}

class Employee1{
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee1(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return Objects.equals(name, employee1.name) && Objects.equals(birthday, employee1.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}