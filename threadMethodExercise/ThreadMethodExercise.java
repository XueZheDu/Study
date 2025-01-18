package cam.gnkjxy.dome1.threadMethodExercise;

/*
线程常用方法课堂练习
1.主线程每隔1s,输出 hi,一共10次
2.当输出到hi 5时，启动一个子线程(要求实现Runnable),每隔1s输出 hello,等
该线程输出10次hello后，退出
3.主线程继续输出hi，直到主线程退出
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new T());

        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            if (i == 5) {
                thread.start();
                thread.join();
            }
            Thread.sleep(1000);
        }

        System.out.println("主线程结束...");
    }
}

class T implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("子线程结束...");
    }
}