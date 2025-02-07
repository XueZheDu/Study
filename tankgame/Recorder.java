package cam.gnkjxy.tankgame;

import java.io.*;
import java.util.Vector;

//用于记录相关信息，可与文件交互
public class Recorder {
    //定义变量，记录玩家击毁敌人坦克数
    private static int allEnemyNum = 0;
    //定义IO对象，写数据到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "src\\myRecord.txt";
    //用于接收敌人信息，方便保存
    private static Vector<Enemy> enemies = null;
    //用于接收文件的敌人信息，方便读取
    private static Vector<Node> nodes = new Vector<>();

    public static int getAllEnemyNum() {
        return allEnemyNum;
    }

    public static void setAllEnemyNum(int allEnemyNum) {
        Recorder.allEnemyNum = allEnemyNum;
    }

    public static Vector<Enemy> getEnemies() {
        return enemies;
    }

    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    //当一个敌人被击毁时，allEnemyNum++
    public static void addAllEnemyNum() {
        Recorder.allEnemyNum++;
    }

    //判断recordFile路径的文件是否存在
    public static Boolean recordFileExists() {
        return new File(recordFile).exists();
    }

    //继续上局游戏初始化时，读取recordFile，恢复相关信息
    public static Vector<Node> getEnemyRecNodes() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyNum = Integer.parseInt(br.readLine());
            //循环读取敌人信息
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] xyDir = line.split(" ");
                Node node = new Node(Integer.parseInt(xyDir[0]), Integer.parseInt(xyDir[1]),
                        Integer.parseInt(xyDir[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes;
    }

    //当游戏退出时，将数据保存到recordFile
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            //保存击毁敌人数
            bw.write(allEnemyNum + "\r\n");
            //保存敌人信息
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if (enemy.isLive) {
                    //将信息保存到文件
                    String record = enemy.getX() + " " + enemy.getY() + " " + enemy.getDirect();
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
