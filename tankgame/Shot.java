package cam.gnkjxy.tankgame;

//射击子弹
public class Shot implements Runnable {
     int x;//子弹x坐标
     int y;//子弹y坐标
     int direct;//子弹的方向
     int speed = 8;//子弹的速度
     boolean isLive = true;//子弹是否还存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向改变x,y坐标
            switch (direct) {
                case 0://向上
                    y -= speed;
                    break;
                case 1://向右
                    x += speed;
                    break;
                case 2://向下
                    y += speed;
                    break;
                case 3://向左
                    x -= speed;
                    break;
            }
            //测试语句，输出子弹坐标
            //System.out.println("子弹：x=" + x + ", y=" + y);
            //当子弹移动到面板边界时或击中坦克时，就应该销毁
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                //测试语句
                //System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}
