package cam.gnkjxy.dome1.synExercise;

public class SynExercise {
    public static void main(String[] args) {
        SellTicked1 sellTicked1 = new SellTicked1();
        new Thread(sellTicked1).start();
        new Thread(sellTicked1).start();
        new Thread(sellTicked1).start();

//        new SellTicked2().start();
//        new SellTicked2().start();
//        new SellTicked2().start();
    }
}

class SellTicked1 implements Runnable {
    private int tickedNum = 100;
    private boolean loop = true;

    public synchronized void sell() {
        if(tickedNum <= 0) {
            loop = false;
            System.out.println("售票结束...");
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" +
                "剩余票数" + --tickedNum);
    }

    @Override
    public void run() {
        while(loop) {
            sell();
        }
    }
}

class SellTicked2 extends Thread {
    private static int tickedNum = 100;
    private static boolean loop = true;

    public static synchronized void sell() {
        if(tickedNum <= 0) {
            loop = false;
            System.out.println("售票结束...");
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" +
                "剩余票数" + --tickedNum);
    }

    @Override
    public void run() {
        while(loop) {
            sell();
        }
    }
}