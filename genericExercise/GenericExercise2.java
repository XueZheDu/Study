package cam.gnkjxy.dome1.genericExercise;

import java.util.ArrayList;
import java.util.Comparator;

/*
泛型课堂练习题
定义Employee类
1)该类包含:private成员变量name,sal,birthday,其中birthday为MyDate类的对
象；
2)为每一个属性定义getter, setter方法:
3)重写toString方法输出name，sal,birthday
4)MyDate类包含:private成员变量month,day,year；并为每一个属性定义getter，
setter方法；
5)创建该类的3个对象，并把这些对象放入ArrayList集合中(ArrayList需使用泛
型来定义)，对集合中的元素进行排序，并遍历输出:
排序方式:调用ArrayList的sort方法，传入Comparator对象[使用泛型]，先按照
name排序，如果name相同，则按生日日期的先后排序。
 */
public class GenericExercise2 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 7000, new MyDate(2003, 4, 5)));
        employees.add(new Employee("jack", 8000, new MyDate(2002, 8, 7)));
        employees.add(new Employee("jack", 9000, new MyDate(2002, 8, 17)));

        System.out.println(employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) {
                    return i;
                }
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        System.out.println(employees);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate myDate) {
        int yearMinus = year - myDate.getYear();
        if (yearMinus != 0) {
            return yearMinus;
        }
        int monthMinus = month - myDate.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }
        return day - myDate.getDay();
    }
}