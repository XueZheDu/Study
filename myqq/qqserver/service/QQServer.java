package cam.gnkjxy.myqq.qqserver.service;

import cam.gnkjxy.myqq.qqcommon.Message;
import cam.gnkjxy.myqq.qqcommon.MessageType;
import cam.gnkjxy.myqq.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XueZheDu
 * @version 1.0
 * 服务端，在9999端口监听，等待客户端的连接并保持通信
 */
public class QQServer {
    private ServerSocket serverSocket = null;
    //创建一个集合，存放多个用户，如果是这些用户登入，就认为是合法
    //这里也可以使用ConcurrentHashMap，可以处理并发的集合，没有线程安全问题
    //HashMap没有处理线程安全问题，因此在多线程情况下是不安全的
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    //创建一个集合，存放离线消息，key是接收离线消息的用户Id，value是存放该用户所有离线消息的集合
    public static ConcurrentHashMap<String, ArrayList<Message>> offLineDb = new ConcurrentHashMap<>();

    static { //在静态代码块中初始化validUsers
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));
        //初始化offLineDb
        offLineDb.put("100", new ArrayList<>());
        offLineDb.put("200", new ArrayList<>());
        offLineDb.put("300", new ArrayList<>());
        offLineDb.put("至尊宝", new ArrayList<>());
        offLineDb.put("紫霞仙子", new ArrayList<>());
        offLineDb.put("菩提老祖", new ArrayList<>());
    }

    public QQServer() {
        try {
            System.out.println("服务端在9999端口监听...");
            serverSocket = new ServerSocket(9999);
            //启动推送新闻的线程
            new Thread(new SendNewsService()).start();

            //当和某个客户端连接后，会继续监听，因此使用while
            while (true) {
                Socket socket = serverSocket.accept(); //如果没有客户端连接，就会阻塞在这里
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject(); //读取客户端发送的User对象
                //验证用户是否合法
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message(); //验证结果通过这个消息回复给客户端
                if (checkUser(user.getUserId(), user.getPasswd())) { //登入成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //回复登入成功Message对象
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, user.getUserId());
                    serverConnectClientThread.start();
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(), serverConnectClientThread);
                    //发送离线消息
                    ArrayList<Message> messages = offLineDb.get(user.getUserId());
                    Iterator<Message> iterator = messages.iterator();
                    while (iterator.hasNext()) {
                        Message offLineMes = iterator.next();
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(offLineMes);
                        iterator.remove();
                    }
                } else { //登入失败
                    System.out.println("用户Id=" + user.getUserId() + " 密码=" + user.getPasswd() + "验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭与登入失败用户连接的Socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //如果服务器退出了while循环，说明服务器停止监听，因此关闭ServerSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //验证用户是否合法
    private boolean checkUser(String userId, String passwd) {
        User user = validUsers.get(userId);
        if (user == null) { //说明该用户Id不在合法用户集合validUsers的key中
            return false;
        }
        if (!user.getPasswd().equals(passwd)) { //用户Id正确，但是密码错误
            return false;
        }
        return true;
    }
}