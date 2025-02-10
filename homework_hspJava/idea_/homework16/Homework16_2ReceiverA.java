package cam.gnkjxy.homework_hspJava.homework16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
2.编程题
(1)编写一个接收端A和一个发送端B，使用UDP协议完成
(2)接收端在8888端口等接收数据(receive)
(3)发送端向接收端发送数据“四大名著是哪些”
(4)接收端接收到发送端发送的问题后，返回“四大名著是《红楼梦》...”,否则返回“what?”
(5)接收端和发送端程序退出
 */
public class Homework16_2ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        //接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端等待接收数据...");
        socket.receive(packet);
        //拆包
        int len = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, len);
        System.out.println(s);
        //回复
        if ("四大名著是哪些".equals(s)) {
            data = "四大名著是《红楼梦》、《水浒传》、《西游记》和《三国演义》".getBytes();
        } else {
            data = "what?".getBytes();
        }
        DatagramPacket packetSend =
                new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
        socket.send(packetSend);
        //关闭资源
        socket.close();
    }
}
