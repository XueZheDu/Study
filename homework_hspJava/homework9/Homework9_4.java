package cam.gnkjxy.homework_hspJava.homework9;

/*
1.有一个交通工具接口类Vehicles，有work方法
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat
作为交通工具 //封装为方法
 */

public class Homework9_4 {
    public static void main(String[] args) {
        Person tangSeng = new Person("唐僧", VehiclesFactory.getHorse());
        tangSeng.common();
        tangSeng.passRiver();
        tangSeng.common();
        tangSeng.passRiver();
        tangSeng.passRiver();
        tangSeng.passRiver();
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("一般情况下，使用马儿前进...");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("过河的时候，使用小船...");
    }
}

class VehiclesFactory {
    //马儿始终是同一匹
    //使用饿汉式
    private static Horse horse = new Horse();
    //构造器私有化
    private VehiclesFactory() {}

    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        //在过河时，使用船作为交通工具，使用前判断交通工具是否为船(包含判断交通工具是否为空)
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        //一般情况下，使用马作为交通工具，使用前判断交通工具是否为马(包含判断交通工具是否为空)
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }
}
