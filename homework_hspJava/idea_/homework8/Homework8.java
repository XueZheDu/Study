package cam.gnkjxy.homework_hspJava.homework8;

/**
 * 1.在Frock类中声明私有的静态属性currentNum[int类型]，初始值为100000，作为衣服出
 * 厂的序列号起始值。
 * 2.声明公有的静态方法getNextNum，作为生成上衣唯一序列号的方法。每调用一次，将
 * currentNum增加100，并作为返回值。
 * 3.在TestFrock类的main方法中，分两次调用getNextNum方法，获取序列号并打印输出。
 * 4.在Frock类中声明serialNumber(序列号)属性，并提供对应的get方法；
 * 5.在Frock类的构造器中，通过调用getNextNum方法为Frock对象获取唯一列号，赋给
 * serialNumber属性。
 * 6.在TestFrock类的main方法中，分别创建三个Frock对象，打印三个对象的序列号，验
 * 证是否为按100递增。
 */
public class Homework8 {
}

class Frock {
    private static int currentNum = 100000; //衣服出厂的序列号起始值
    private int serialNumber; //序列号

    public Frock() {
        serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum() {
        return currentNum += 100;
    }
}

class TestFrock {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println("frock1的序列号=" + frock1.getSerialNumber());
        System.out.println("frock2的序列号=" + frock2.getSerialNumber());
        System.out.println("frock3的序列号=" + frock3.getSerialNumber());

    }
}
