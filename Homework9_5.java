package cam.gnkjxy.homework_hspJava.homework9;

/*
内部类练习
有一个Car类，有属性temperature (温度)，车内有Air (空调)类，有吹风的功能flow，
Air会监视车内的温度。如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，如果在这之
间则关掉空调。实例化具有不同温度的Car对象，调用空调的floW方法，测试空调吹的风是否正确
 */

public class Homework9_5 {
    public static void main(String[] args) {
        Car car = new Car(45);
        Car car2 = new Car(-3);
        Car car3 = new Car(25);
        car.new Air().flow();
        car2.new Air().flow();
        car3.new Air().flow();
    }
}

class Car {
    private double temperature;
    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("空调吹冷气");
            } else if (temperature < 0) {
                System.out.println("空调吹暖气");
            } else {
                System.out.println("关闭空调");
            }
        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}