package cam.gnkjxy.tankgame;

public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct = 0;//坦克方向 0上 1右 2下 3左
    private int speed = 3;
    boolean isLive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //上右下左移动坐标方法
    public void moveUp() {
        if(y > 0) {
            y -= speed;
        }
    }
    public void moveRight() {
        if(x + 60 < 1000) {
            x += speed;
        }
    }
    public void moveDown() {
        if(y + 60 < 750) {
            y += speed;
        }
    }
    public void moveLeft() {
        if(x > 0) {
            x -= speed;
        }
    }
}
