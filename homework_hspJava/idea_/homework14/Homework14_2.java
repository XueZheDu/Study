package cam.gnkjxy.homework_hspJava.homework14;

/*
2.编程题
(1)有2个用户分别从同一个卡上取钱(总额:10000)
(2)每次都取1000，当余额不足时，就不能取款了
(3)不能出现超取现象 =》线程同步问题
 */
public class Homework14_2 {
    public static void main(String[] args) {
        Card card = new Card();
        new Thread(card).start();
        new Thread(card).start();
    }
}

class Card implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "已成功取出1000元，还剩" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}