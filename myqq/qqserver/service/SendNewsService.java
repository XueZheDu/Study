package cam.gnkjxy.myqq.qqserver.service;

import cam.gnkjxy.myqq.qqcommon.Message;
import cam.gnkjxy.myqq.qqcommon.MessageType;
import cam.gnkjxy.myqq.qqserver.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author XueZheDu
 * @version 1.0
 */
public class SendNewsService implements Runnable {

    @Override
    public void run() {
        //为了多次推送新闻，使用while循环
        while (true) {
            System.out.println("请输入服务器要推送的新闻/消息：");
            String news = Utility.readString(100);
            //构建一个消息，然后群发消息
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            System.out.println("服务器 推送消息给所有人：" + news);
            System.out.println("--时间：" + message.getSendTime());

            //遍历在线用户通信线程集合，得到socket，群发message
            HashMap<String, ServerConnectClientThread> hashMap = ManageServerConnectClientThread.getHashMap();
            Iterator<String> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                String onLineUserId = iterator.next();
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(hashMap.get(onLineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
