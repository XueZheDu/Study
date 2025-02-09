package cam.gnkjxy.dome1.socketExercise;

import java.io.IOException;
import java.net.*;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象，准备发送数据
        DatagramSocket socket = new DatagramSocket(9998);
        //2.将需要发送的数据，封装到DatagramPacket对象
        byte[] data = "hello，明天吃火锅~".getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);
        //3.接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packetReceive = new DatagramPacket(buf, buf.length);
        socket.receive(packetReceive);
        int length = packetReceive.getLength();
        byte[] dataReceive = packetReceive.getData();
        String s = new String(dataReceive, 0, length);
        System.out.println(s);
        //4.关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
