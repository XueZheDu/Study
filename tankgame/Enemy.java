package cam.gnkjxy.tankgame;

import java.util.Vector;

//敌人的坦克
public class Enemy extends Tank implements Runnable {
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    //用于接收其他敌人坦克信息
    Vector<Enemy> enemies = new Vector<>();

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void setEnemies(Vector<Enemy> enemies) {
        this.enemies = enemies;
    }

    public boolean isTouchEnemy() {//判断是否与其他敌人坦克碰撞
        switch (getDirect()) {
            case 0://上
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    if (enemy != this && enemy.isLive) {
                        //如果敌人坦克方向为上或下
                        //敌人坦克x的范围为[x, x+40]，y的范围[y, y+60]
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            //判断当前坦克的左上角与右上角是否进入敌人坦克范围
                            //左上角坐标(x,y)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 40
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 60) {
                                return true;
                            }
                            //右上角坐标(x+40, y)
                            if (getX() + 40 >= enemy.getX() && getX() + 40 <= enemy.getX() + 40
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克方向为右或左
                        //敌人坦克x的范围为[x, x+60]，y的范围[y, y+40]
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            //判断当前坦克的左上角与右上角是否进入敌人坦克范围
                            //左上角坐标(x,y)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 60
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 40) {
                                return true;
                            }
                            //右上角坐标(x+40, y)
                            if (getX() + 40 >= enemy.getX() && getX() + 40 <= enemy.getX() + 60
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://右
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    if (enemy != this && enemy.isLive) {
                        //如果敌人坦克方向为上或下
                        //敌人坦克x的范围为[x, x+40]，y的范围[y, y+60]
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            //判断当前坦克的右上角与右下角是否进入敌人坦克范围
                            //右上角坐标(x+60,y)
                            if (getX() + 60 >= enemy.getX() && getX() + 60 <= enemy.getX() + 40
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 60) {
                                return true;
                            }
                            //右下角坐标(x+60, y+40)
                            if (getX() + 60 >= enemy.getX() && getX() + 60 <= enemy.getX() + 40
                                    && getY() + 40 >= enemy.getY() && getY() + 40 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克方向为右或左
                        //敌人坦克x的范围为[x, x+60]，y的范围[y, y+40]
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            //判断当前坦克的右上角与右下角是否进入敌人坦克范围
                            //右上角坐标(x+60,y)
                            if (getX() + 60 >= enemy.getX() && getX() + 60 <= enemy.getX() + 60
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 40) {
                                return true;
                            }
                            //右下角坐标(x+60, y+40)
                            if (getX() + 60 >= enemy.getX() && getX() + 60 <= enemy.getX() + 60
                                    && getY() + 40 >= enemy.getY() && getY() + 40 <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    if (enemy != this && enemy.isLive) {
                        //如果敌人坦克方向为上或下
                        //敌人坦克x的范围为[x, x+40]，y的范围[y, y+60]
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            //判断当前坦克的左下角与右下角是否进入敌人坦克范围
                            //左下角坐标(x,y+60)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 40
                                    && getY() + 60 >= enemy.getY() && getY() + 60 <= enemy.getY() + 60) {
                                return true;
                            }
                            //右下角坐标(x+40, y+60)
                            if (getX() + 40 >= enemy.getX() && getX() + 40 <= enemy.getX() + 40
                                    && getY() + 60 >= enemy.getY() && getY() + 60 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克方向为右或左
                        //敌人坦克x的范围为[x, x+60]，y的范围[y, y+40]
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            //判断当前坦克的左下角与右下角是否进入敌人坦克范围
                            //左下角坐标(x,y+60)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 60
                                    && getY() + 60 >= enemy.getY() && getY() + 60 <= enemy.getY() + 40) {
                                return true;
                            }
                            //右下角坐标(x+40, y+60)
                            if (getX() + 40 >= enemy.getX() && getX() + 40 <= enemy.getX() + 60
                                    && getY() + 60 >= enemy.getY() && getY() + 60 <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    if (enemy != this && enemy.isLive) {
                        //如果敌人坦克方向为上或下
                        //敌人坦克x的范围为[x, x+40]，y的范围[y, y+60]
                        if (enemy.getDirect() == 0 || enemy.getDirect() == 2) {
                            //判断当前坦克的左上角与左下角是否进入敌人坦克范围
                            //左上角坐标(x,y)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 40
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 60) {
                                return true;
                            }
                            //右下角坐标(x, y+40)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 40
                                    && getY() + 40 >= enemy.getY() && getY() + 40 <= enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克方向为右或左
                        //敌人坦克x的范围为[x, x+60]，y的范围[y, y+40]
                        if (enemy.getDirect() == 1 || enemy.getDirect() == 3) {
                            //判断当前坦克的左上角与左下角是否进入敌人坦克范围
                            //左上角坐标(x,y)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 60
                                    && getY() >= enemy.getY() && getY() <= enemy.getY() + 40) {
                                return true;
                            }
                            //右下角坐标(x, y+40)
                            if (getX() >= enemy.getX() && getX() <= enemy.getX() + 60
                                    && getY() + 40 >= enemy.getY() && getY() + 40 <= enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {
        while (isLive) {
            //随机改变坦克方向
            setDirect((int) (Math.random() * 4));
            //随机决定坦克移动步数
            int ranNum = (int) (Math.random() * 16 + 15);
            //根据坦克的方向来继续移动 + 发射子弹
            switch (getDirect()) {
                case 0://向上
                    if (shots.size() < 1) {//小于号后面设置子弹个数
                        shot = new Shot(getX() + 19, getY(), 0);
                        shots.add(shot);
                        new Thread(shot).start();
                    }
                    for (int i = 0; i < ranNum; i++) {
                        if (!isTouchEnemy()) {
                            moveUp();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1://向右
                    if (shots.size() < 1) {
                        shot = new Shot(getX() + 60, getY() + 19, 1);
                        shots.add(shot);
                        new Thread(shot).start();
                    }
                    for (int i = 0; i < ranNum; i++) {
                        if (!isTouchEnemy()) {
                            moveRight();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2://向下
                    if (shots.size() < 1) {
                        shot = new Shot(getX() + 19, getY() + 60, 2);
                        shots.add(shot);
                        new Thread(shot).start();
                    }
                    for (int i = 0; i < ranNum; i++) {
                        if (!isTouchEnemy()) {
                            moveDown();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3://向左
                    if (shots.size() < 1) {
                        shot = new Shot(getX(), getY() + 19, 3);
                        shots.add(shot);
                        new Thread(shot).start();
                    }
                    for (int i = 0; i < ranNum; i++) {
                        if (!isTouchEnemy()) {
                            moveLeft();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
        }
        //测试语句
        //System.out.println("敌人坦克线程退出");
    }
}
