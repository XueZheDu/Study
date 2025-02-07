package cam.gnkjxy.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

//游戏窗口
public class TankGame01 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        System.out.println("请输入选择：1.新游戏 2.继续游戏");
        String key = scanner.next();
        mp = new MyPanel(key);
        this.add(mp);//将游戏的绘图区域加入窗口
        this.setSize(1300, 787);
        new Thread(mp).start();//将mp放入到Thread，并启动
        this.addKeyListener(mp);//让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
