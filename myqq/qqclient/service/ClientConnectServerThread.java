package cam.gnkjxy.myqq.qqclient.service;

import cam.gnkjxy.myqq.qqcommon.Message;
import cam.gnkjxy.myqq.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author XueZheDu
 * @version 1.0
 * 该类的一个对象可以和服务端保持通信
 */
public class ClientConnectServerThread extends Thread {
    private Socket socket;

    //构造器可以接收一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        //该线程需要在后台和服务器通信，因此做成while循环
        while (true) {
            try {
                System.out.println("客户端线程，等待服务器端发送消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                //判断message类型，然后做业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //如果消息类型是 返回在线用户列表
                    //信息内容规定以空格为分隔符
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n============当前在线用户列表============");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //群发的聊天消息
                    //显示群发消息的内容
                    System.out.println("\n" + message.getSender() + " 对大家说：" + message.getContent());
                    System.out.println("--时间：" + message.getSendTime());
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //普通的聊天消息
                    //把服务端转发过来的消息的内容显示到控制台
                    System.out.println("\n" + message.getSender()
                            + " 对 " + message.getReceiver() + " 说：" + message.getContent());
                    System.out.println("--时间：" + message.getSendTime());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //文件消息
                    System.out.println("\n" + message.getSender() + " 给 " + message.getReceiver()
                            + " 发送文件 " + message.getSrc() + " 到我的电脑目录 " + message.getDest());
                    System.out.println("--时间：" + message.getSendTime());
                    //将message内的字节数组保存到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("文件保存成功");
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT_SUCCESS)) {
                    //从管理线程集合中删除需退出的线程，关闭对应的socket
                    System.out.println(message.getReceiver() + " 成功退出");
                    ManageClientConnectServerThread.removeClientConnectServerThread(message.getReceiver());
                    socket.close();
                    //退出线程
                    break;
                } else {
                    System.out.println("是其他类型的message，现在暂时不处理...");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
