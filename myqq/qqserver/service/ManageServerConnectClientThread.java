package cam.gnkjxy.myqq.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author XueZheDu
 * @version 1.0
 * 管理服务端连接客户端线程的类
 */
public class ManageServerConnectClientThread {
    //把多个线程放入一个HashMap集合，key就是用户id，value就是线程
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    //返回HashMap集合
    public static HashMap<String, ServerConnectClientThread> getHashMap() {
        return hashMap;
    }

    //将某个线程加入到集合
    public static void addServerConnectClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hashMap.put(userId, serverConnectClientThread);
    }

    //通过userId可以得到对应线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hashMap.get(userId);
    }

    //通过userId可以从集合里删除对应线程
    public static void removeServerConnectClientThread(String userId) {
        hashMap.remove(userId);
    }

    //返回在线用户列表
    public static String getOnlineUserList() {
        //获取集合的key，遍历key
        Iterator<String> iterator = hashMap.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next() + " ";
        }
        return onlineUserList;
    }
}
