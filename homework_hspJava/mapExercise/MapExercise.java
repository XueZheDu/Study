package cam.gnkjxy.dome1.mapExercise;

import java.util.*;

/*
Map接口课堂练习
使用HashMap添加3个员工对象，要求
键:员工id
值: 员工对象
井遍历显示工资>18000的员工(遍历方式最少两种)
员工类:姓名、工资、员工id
 */
public class MapExercise {
    public static void main(String[] args) {
        Map hashMap = new HashMap();

        Employee employee1 = new Employee("张三", 7000, 1001);
        Employee employee2 = new Employee("李四", 12000, 1002);
        Employee employee3 = new Employee("王五", 20000, 1003);

        hashMap.put(employee1.getId(), employee1);
        hashMap.put(employee2.getId(), employee2);
        hashMap.put(employee3.getId(), employee3);

        //使用keySet
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            if(((Employee) hashMap.get(key)).getSalary() > 18000)
                System.out.println(hashMap.get(key));
        }
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if(((Employee) hashMap.get(key)).getSalary() > 18000)
                System.out.println(hashMap.get(key));
        }

        //使用values
        Collection values = hashMap.values();
        for (Object value : values) {
            if(((Employee) value).getSalary() > 18000)
                System.out.println(value);
        }
        iterator = values.iterator();
        while (iterator.hasNext()) {
            Object value =  iterator.next();
            if(((Employee) value).getSalary() > 18000)
                System.out.println(value);
        }

        //使用entrySet
        Set entrySet = hashMap.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            if(((Employee) entry.getValue()).getSalary() > 18000)
                System.out.println(entry.getValue());
        }
        iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator.next();
            if(((Employee) entry.getValue()).getSalary() > 18000)
                System.out.println(entry.getValue());
        }

    }
}

class Employee{
    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
