package cam.gnkjxy.myqq.qqclient.service;

import java.util.HashMap;

/**
 * @author XueZheDu
 * @version 1.0
 * 管理客户端连接服务器端线程的类
 */
public class ManageClientConnectServerThread {
    //把多个线程放入一个HashMap集合，key就是用户id，value就是线程
    private static HashMap<String, ClientConnectServerThread> hashMap = new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hashMap.put(userId, clientConnectServerThread);
    }

    //通过userId可以得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hashMap.get(userId);
    }

    //通过userId可以从集合里删除对应线程
    public static void removeClientConnectServerThread(String userId) {
        hashMap.remove(userId);
    }
}
