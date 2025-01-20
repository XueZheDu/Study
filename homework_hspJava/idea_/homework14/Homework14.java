package cam.gnkjxy.homework_hspJava.homework14;

import java.util.Scanner;

/*
1.编程题
(1)在main方法中启动两个线程
(2)第1个线程循环随机打印100以内的整数
(3)直到第2个线程从键盘读取了“Q”命令。
 */
public class Homework14 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        new Thread(t1).start();
        new Thread(t2).start();
    }
}

class T1 implements Runnable {
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        //循环随机打印100以内的整数
        while (loop) {
            System.out.println((int)(Math.random() * 100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("t1线程退出...");
    }
}

class T2 implements Runnable {
    private T1 t1;
    private Scanner scanner = new Scanner(System.in);

    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令（Q表示退出）：");
            if (scanner.next().toUpperCase().charAt(0) == 'Q') {
                t1.setLoop(false);
                System.out.println("t2线程退出...");
                break;
            }
        }
    }
}
