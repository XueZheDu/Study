package cam.gnkjxy.dome1.finalExercise;

public class FinalExercise {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("面积=" + circle.calArea());
    }
}

//请编写一个程序，能够计算圆形的面积。要求圆周率为3.14。
//赋值的位置3个位置方式都写一下
class Circle {
    public double radius;
    public final double PI = 3.14;
    public final double PI2;
    public final double PI3;
    {
        PI2 = 3.14;
    }
    public Circle(double radius) {
        this.radius = radius;
        PI3 = 3.14;
    }
    public double calArea() {
        return PI * radius * radius;
    }
}
