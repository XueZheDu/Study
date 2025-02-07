package cam.gnkjxy.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//坦克大战的绘图区域
//为了监听键盘时间，实现KeyListener
//为了不停地重绘子弹，需要实现Runnable，当作一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义玩家的坦克
    Hero hero;
    //定义一个Vector，用于存放敌人的坦克
    Vector<Enemy> enemies = new Vector<>();
    int enemySize = 6;//敌人坦克数量
    //定义一个Vector，用于接收文件敌人信息Node，便于恢复上局敌人信息
    Vector<Node> nodes = new Vector<>();
    //定义一个Vector，用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key) {
        //将Recorder对象的enemies指向MyPanel的enemies
        Recorder.setEnemies(enemies);
        //初始化玩家的坦克
        hero = new Hero(300, 690);
        //当选择继续游戏时，判断存档文件是否存在，存在则继续下一步，不存在则只能开始新游戏
        if (key.equals("2") && !Recorder.recordFileExists()) {
            System.out.println("没有找到上局游戏记录，自动开始新游戏");
            key = "1";
        }
        //新游戏/继续游戏
        switch (key) {
            case "1": //新游戏
                //初始化敌人的坦克
                for (int i = 0; i < enemySize; i++) {
                    //创建一个敌人坦克
                    Enemy enemy = new Enemy(150 * (i + 1), 0);
                    //让敌人坦克内置的enemies指向MyPanel的enemies
                    enemy.setEnemies(enemies);
                    //设置敌人坦克方向
                    enemy.setDirect(2);
                    //启动敌人坦克线程，让它开始移动
                    new Thread(enemy).start();
                    //加入敌人坦克集合
                    enemies.add(enemy);
                }
                break;
            case "2": //继续游戏
                //接收上局游戏敌人信息（该方法会恢复击毁敌人数）
                nodes = Recorder.getEnemyRecNodes();
                //恢复敌人的坦克
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    //创建一个敌人坦克
                    Enemy enemy = new Enemy(node.getX(), node.getY());
                    //让敌人坦克内置的enemies指向MyPanel的enemies
                    enemy.setEnemies(enemies);
                    //设置敌人坦克方向
                    enemy.setDirect(node.getDirect());
                    //启动敌人坦克线程，让它开始移动
                    new Thread(enemy).start();
                    //加入敌人坦克集合
                    enemies.add(enemy);
                }
                break;
            default:
                System.out.println("输入有误");
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.png"));
        //初始化bombs集合（解决第一次调用g.drawImage()方法图片不显示问题）
        bombs.add(new Bomb(0, 0));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色，作为游戏背景
        showInfo(g);
        //画出玩家的坦克
        if(hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        } else {
            //重新初始化坦克
            hero.setX(300);
            hero.setY(690);
            hero.setDirect(0);
            hero.isLive = true;
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }
        //画出hero射出的子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot.isLive) {
                g.fillOval(shot.x, shot.y, 2, 2);
            } else {
                hero.shots.remove(shot);
                i--; //删除元素后，后面的元素会填补空缺，需要再次遍历删除元素下标位置
            }
        }
        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            //根据当前bomb的life值画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //炸弹的生命值减少
            bomb.lifeDown();
            //如果炸弹的生命值减为0，就从bombs集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
                i--;
            }
        }
        //画出敌人的坦克
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.isLive) {
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 1);
                //画出该敌人坦克的所有子弹
                for (int j = 0; j < enemy.shots.size(); j++) {
                    Shot shot = enemy.shots.get(j);
                    if (shot.isLive) {
                        g.fillOval(shot.x, shot.y, 2, 2);
                    } else {
                        enemy.shots.remove(shot);
                        i--;
                    }
                }
            } else {
                enemies.remove(enemy);
                i--;
            }
        }
    }

    /**
     * 画出坦克方法
     *
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0://玩家的坦克
                g.setColor(Color.yellow);
                break;
            case 1://敌人的坦克
                g.setColor(Color.cyan);
                break;
        }
        //根据坦克方向，来绘制坦克
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克身体
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆盖
                g.fill3DRect(x + 19, y, 2, 30, false);//画出坦克炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克身体
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克圆盖
                g.fill3DRect(x + 30, y + 19, 30, 2, false);//画出坦克炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克身体
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆盖
                g.fill3DRect(x + 19, y + 30, 2, 30, false);//画出坦克炮筒
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克身体
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克圆盖
                g.fill3DRect(x, y + 19, 30, 2, false);//画出坦克炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //显示玩家击毁敌人坦克的数量信息
    public void showInfo(Graphics g) {
        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("您累积击毁敌方坦克", 1020, 30);
        g.drawString(Recorder.getAllEnemyNum() + "", 1080, 100);
        drawTank(1020, 60, g, 0, 1);
    }

    //判断子弹是否击中坦克
    public void hitTank(Shot shot, Tank tank) {
        switch (tank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下
                if (shot.x > tank.getX() && shot.x < tank.getX() + 40
                        && shot.y > tank.getY() && shot.y < tank.getY() + 60) {
                    shot.isLive = false;
                    tank.isLive = false;
                    //如果是敌人坦克被击毁，就让击毁敌人数加1
                    if (tank instanceof Enemy) {
                        Recorder.addAllEnemyNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (shot.x > tank.getX() && shot.x < tank.getX() + 60
                        && shot.y > tank.getY() && shot.y < tank.getY() + 40) {
                    shot.isLive = false;
                    tank.isLive = false;
                    //如果是敌人坦克被击毁，就让击毁敌人数加1
                    if (tank instanceof Enemy) {
                        Recorder.addAllEnemyNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //判断玩家子弹是否击中敌人
    public void hitEnemy() {
        //遍历玩家子弹
        for(int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            //判断玩家的子弹是否击中敌人
            if (shot.isLive) {
                for (int j = 0; j < enemies.size(); j++) {
                    Enemy enemy = enemies.get(j);
                    if (enemy.isLive) {
                        hitTank(shot, enemy);
                    }
                }
            }
        }
    }

    //判断敌人子弹是否击中玩家
    public void hitHero() {
        //遍历敌人坦克
        for(int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            //遍历当前敌人的所有子弹
            if (enemy.isLive) {
                for (int j = 0; j < enemy.shots.size(); j++) {
                    Shot shot = enemy.shots.get(j);
                    if (hero.isLive && shot.isLive) {
                        hitTank(shot, hero);
                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //处理wasd键按下的情况
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下W键
            //改变坦克方向
            hero.setDirect(0);
            //修改坦克坐标 y -= 1
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//按下D键
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//按下S键
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//按下A键
            hero.setDirect(3);
            hero.moveLeft();
        }
        //如果用户按下J键（攻击键），就发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J && hero.isLive) {
            hero.shotEnemy();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100毫秒，重绘区域
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断玩家是否击中敌人
            hitEnemy();
            //判断敌人是否击中玩家
            hitHero();
            //重绘
            this.repaint();
        }
    }
}
