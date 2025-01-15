package cam.gnkjxy.dome1.linkedHashSetExercise;

import java.util.LinkedHashSet;
import java.util.Objects;

/*
LinkedHashSet课后练习题
Car类(属性:name,price),如果name和price一样，则认为是相同元素，就不能添加。
 */
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        Car car1 = new Car("小车", 20000);
        Car car2 = new Car("大车", 50000);
        Car car3 = new Car("大车", 50000);

        linkedHashSet.add(car1);
        linkedHashSet.add(car2);
        linkedHashSet.add(car3);
    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
