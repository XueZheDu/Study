package cam.gnkjxy.homework_hspJava.homework9;

/*
内部类
1.编一个类A，在类中定义局部内部类B，B中有一个私有常量name，有一个方法show()
打印常量name，进行测试
2.进阶:A中也定义一个私有的变业name，在show方法中打印测试
 */

public class Homework9_3 {
    public static void main(String[] args) {
        //测试
        new A().f1();
    }
}

class A {
    private String name = "hello";

    public void f1() {
        class B {
            private final String NAME = "B";
            public void show() {
                System.out.println(NAME);
                System.out.println("外部类A的name：" + name); //如果重名用A.this.变量(常量)名
            }
        }
        B b = new B();
        b.show();
    }
}