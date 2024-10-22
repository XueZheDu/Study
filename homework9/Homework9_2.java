package cam.gnkjxy.homework_hspJava.homework9;

/*
4.编程题
1.计算器接口具有work方法，功能是运算，有一个手机类Cellphone，定义方法testWork
测试计算功能，调用计算接口的work方法，
2.要求调用CellPhone对象的testWork方法，使用上匿名内部类
 */

public class Homework9_2 {
    public static void main(String[] args) {
        //测试
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10, 8);

        cellPhone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        }, 10, 8);
    }
}

interface ICalculate {
    public double work(double n1, double n2);
}

class CellPhone {
    public void testWork(ICalculate icalculate, double n1, double n2) {
        double res = icalculate.work(n1, n2);
        System.out.println("计算的结果是：" + res);
    }
}