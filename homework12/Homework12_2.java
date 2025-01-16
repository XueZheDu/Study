package cam.gnkjxy.homework_hspJava.homework12;

import java.util.ArrayList;
import java.util.Iterator;

/*
2.编程题
使用ArrayList完成对对象Car{name,price}的各种操作
1.add:添加单个元素
2.remove:删除指定元素
3.contains:查找元素是否存在
4.size:获取元素个数
5.isEmpty:判断是否为空
6.clear:清空
7.addAl:添加多个元素
8.containsAIl:查找多个元素是否都存在
9.removeAll:删除多个元素
使用增强for和迭代器来遍历所有的car，需要重写Car的toString方法
 */
public class Homework12_2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);

        arrayList.add(car1);
        arrayList.add(car2);
        System.out.println(arrayList);

        arrayList.remove(car1);
        System.out.println(arrayList);

        System.out.println(arrayList.contains(car1));
        System.out.println(arrayList.contains(car2));

        System.out.println(arrayList.size());

        System.out.println(arrayList.isEmpty());

        arrayList.clear();
        System.out.println(arrayList);

        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(car1);
        arrayList2.add(car2);
        arrayList.addAll(arrayList2);
        System.out.println(arrayList);

        System.out.println(arrayList.containsAll(arrayList2));

        arrayList.removeAll(arrayList2);
        System.out.println(arrayList);

        for (Object o : arrayList2) {
            System.out.println(o);
        }

        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
