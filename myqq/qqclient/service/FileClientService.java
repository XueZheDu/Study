package cam.gnkjxy.myqq.qqclient.service;

import cam.gnkjxy.myqq.qqcommon.Message;
import cam.gnkjxy.myqq.qqcommon.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author XueZheDu
 * @version 1.0
 */
public class FileClientService {

    /**
     * @param src 源文件
     * @param dest 文件发送目的地目录
     * @param senderId 发送用户Id
     * @param receiverId 接收用户Id
     */
    public void sendFile(String src, String dest, String senderId, String receiverId) {
        //读取src文件到message
        Message message = new Message();
        message.setSender(senderId);
        message.setReceiver(receiverId);
        message.setSendTime(new Date().toString());
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSrc(src);
        message.setDest(dest);

        //读取文件
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes); //将src文件读取到程序的字节数组
            //将文件对应的程序字节数组设置到message内
            message.setFileBytes(fileBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //提示信息
        System.out.println("\n" + senderId + " 给 " + receiverId + " 发送文件 " + src
                + " 到对方的电脑目录 " + dest);
        System.out.println("--时间：" + message.getSendTime());
        //发送message
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
