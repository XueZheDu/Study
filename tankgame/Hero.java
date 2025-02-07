package cam.gnkjxy.tankgame;

import java.util.Vector;

//玩家的坦克
public class Hero extends Tank {
    Shot shot = null;//表示一个射击行为（线程）
    Vector<Shot> shots = new Vector<>(); //可以发射多颗子弹

    public Hero(int x, int y) {
        super(x, y);
    }

    //射击
    public void shotEnemy() {
        //控制面板上最多只存在五颗玩家子弹
        if(!(shots.size() < 1)){//小于号后面设置子弹个数
            return;
        }
        //创建Shot对象，根据当前Hero对象的位置和方向来创建Shot
        switch (getDirect()) {
            case 0://向上
                shot = new Shot(getX() + 19, getY(), 0);
                break;
            case 1://向右
                shot = new Shot(getX() + 60, getY() + 19, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 19, getY() + 60, 2);
                break;
            case 3://向左
                shot = new Shot(getX(), getY() + 19, 3);
                break;
        }
        //将新创建的shot放入到shots中
        shots.add(shot);
        //启动Shot线程
        new Thread(shot).start();
    }
}
