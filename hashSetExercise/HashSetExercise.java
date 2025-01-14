package cam.gnkjxy.dome1.hashSetExercise;

import java.util.HashSet;
import java.util.Objects;

/*
HashSet课堂练习1
定义一个Employee类，该类包含:private成员属性name， age要求:
1.创建3个Employee放入HashSet中
2.当name和age的值相同时，认为是相同员工不能添加到HashSet集合中
 */
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Employee employee1 = new Employee("张三", 23);
        Employee employee2 = new Employee("李四", 22);
        Employee employee3 = new Employee("李四", 22);

        hashSet.add(employee1);
        hashSet.add(employee2);
        hashSet.add(employee3);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
