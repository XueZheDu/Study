package cam.gnkjxy.myqq.qqclient.service;

import cam.gnkjxy.myqq.qqcommon.Message;
import cam.gnkjxy.myqq.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author XueZheDu
 * @version 1.0
 * 提供和消息相关的服务方法
 */
public class MessageClientService {

    /**
     * @param content 内容
     * @param senderId 发送用户Id
     */
    public void sendMessageToAll(String content, String senderId) {
        //构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString()); //设置发送时间
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES); //类型为群发信息包
        System.out.println(senderId + " 对大家说：" + content);
        System.out.println("--时间：" + message.getSendTime());
        //发送消息给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param content 内容
     * @param senderId 发送用户Id
     * @param receiverId 接收用户Id
     */
    public void sendMessage(String content, String senderId, String receiverId) {
        //构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setReceiver(receiverId);
        message.setContent(content);
        message.setSendTime(new Date().toString()); //设置发送时间
        message.setMesType(MessageType.MESSAGE_COMM_MES); //类型为普通信息包
        System.out.println(senderId + " 对 " + receiverId + " 说：" + content);
        System.out.println("--时间：" + message.getSendTime());
        //发送消息给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
