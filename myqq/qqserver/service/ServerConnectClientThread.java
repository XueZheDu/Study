package cam.gnkjxy.myqq.qqserver.service;

import cam.gnkjxy.myqq.qqcommon.Message;
import cam.gnkjxy.myqq.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author XueZheDu
 * @version 1.0
 * 该类的一个对象可以和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId; //连接服务端的用户Id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() { //这里线程处于run的状态，可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端 " + userId + " 保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //根据message的类型，做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要求返回在线用户列表
                    System.out.println(message.getSender() + " 要在线用户列表");
                    //获取在线用户列表
                    String onlineUserList = ManageServerConnectClientThread.getOnlineUserList();
                    //设置回复在线用户列表的message
                    Message messageRet = new Message();
                    messageRet.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    messageRet.setContent(onlineUserList);
                    messageRet.setReceiver(message.getSender());
                    //发送给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(messageRet);
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //群发的聊天消息
                    //遍历所有在线用户的线程和socket，并转发message
                    HashMap<String, ServerConnectClientThread> hashMap = ManageServerConnectClientThread.getHashMap();
                    Iterator<String> iterator = hashMap.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户线程，除了发送人自己
                        String onLineUserId = iterator.next();
                        if (!onLineUserId.equals(message.getSender())) {
                            //如果不是发送人自己，就转发message
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(hashMap.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //普通的聊天消息
                    //根据receiver获取对应线程
                    ServerConnectClientThread serverConnectClientThread =
                            ManageServerConnectClientThread.getServerConnectClientThread(message.getReceiver());
                    if (serverConnectClientThread == null) {
                        //用户不在线，存放该用户的留言消息集合
                        ArrayList<Message> messages = QQServer.offLineDb.get(message.getReceiver());
                        messages.add(message);
                        continue;
                    }
                    //通过线程得到对应socket的输出流，将message转发给receiver的客户端
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message); //转发message，如果有数据库，可以保持至数据库，实现离线留言
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //文件消息
                    //根据receiver获取对应线程，将message转发至receiver的客户端
                    ServerConnectClientThread serverConnectClientThread =
                            ManageServerConnectClientThread.getServerConnectClientThread(message.getReceiver());
                    if (serverConnectClientThread == null) {
                        //用户不在线，存放该用户的留言消息集合
                        ArrayList<Message> messages = QQServer.offLineDb.get(message.getReceiver());
                        messages.add(message);
                        continue;
                    }
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    //客户端退出系统
                    //回复退出系统消息给客户端，用于退出客户端进程
                    Message messageRet = new Message();
                    messageRet.setMesType(MessageType.MESSAGE_CLIENT_EXIT_SUCCESS);
                    messageRet.setReceiver(message.getSender());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(messageRet);
                    //从管理线程集合中删除需退出的线程，关闭对应的socket
                    System.out.println(message.getSender() + " 退出");
                    ManageServerConnectClientThread.removeServerConnectClientThread(message.getSender());
                    socket.close();
                    //退出线程
                    break;
                } else {
                    System.out.println("其他类型的message，现在暂时不处理...");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
