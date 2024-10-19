package cam.gnkjxy.dome1.innerClassExercise;

public class InnerClassExercise {
    public static void main(String[] args) {

        //1.当作实参直接传递，简洁高效
        f1(new IA() {
            @Override
            public void show() {
                System.out.println("这是一副名画...");
            }
        });
        //传统方法
        f1(new A());

        //测试
        Cellphone cellphone = new Cellphone();
        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellphone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });

    }

    //静态方法，形参是接口类型
    public static void f1(IA ia) {
        ia.show();
    }

}

//接口
interface IA {
    void show();
}

//类-->实现IA(编程领域称之为 硬编码)(如果只用一次，使用匿名内部类更方便)
class A implements IA {
    @Override
    public void show() {
        System.out.println("这是一副名画...");
    }
}

/**
 * 匿名内部类课堂练习
 * 1.有一个铃声接口Bell，里面有个ring方法。
 * 2.有一个手机类Cellphone，具有闹钟功能alarmclock，参数是Bell类型
 * 3.测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印:懒猪起床了
 * 4.再传入另一个匿名内部类(对象)，打印:小伙伴上课了
 * interface Bell{
 *     void ring();
 * }
 * class Cellphone {
 *     public void alarmclock(Bell bell) {
 *         bell.ring();
 *     }
 * }
 */
interface Bell{ //接口
    void ring(); //方法
}
class Cellphone { //类
    public void alarmclock(Bell bell) { //形参是Bell接口类型
        bell.ring();
    }
}