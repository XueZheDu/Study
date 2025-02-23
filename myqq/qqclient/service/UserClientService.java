package cam.gnkjxy.myqq.qqclient.service;

import cam.gnkjxy.myqq.qqcommon.Message;
import cam.gnkjxy.myqq.qqcommon.MessageType;
import cam.gnkjxy.myqq.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author XueZheDu
 * @version 1.0
 * 完成用户登入验证和用户注册等与用户相关的功能
 */
public class UserClientService {
    private User u = new User();
    private Socket socket;

    //根据userId和password到服务器验证该用户是否合法
    public boolean checkUser(String userId, String password) {
        boolean flag = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(password);
        //连接服务端，发送User对象，读取回复的Message对象，验证用户是否合法
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //发送User对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            //读取回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            //验证用户是否合法
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                //登入成功后，创建一个和服务器端保持通信的线程
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                flag = true;
            } else {
                //登入失败，不能启动和服务器通信的线程，关闭socket
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    //向服务器端请求在线用户列表，使用该方法前需调用过一次checkUser方法，并且用户是合法的
    public void onlineFriendList() {
        //发送一个Message，类型为MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送信息给服务器
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //退出客户端，并向服务端发送一个退出信息的message
    public void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        //发送message
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
