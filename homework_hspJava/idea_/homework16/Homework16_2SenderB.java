package cam.gnkjxy.homework_hspJava.homework16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Homework16_2SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8887);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String input = scanner.next();
        //发送数据
        byte[] data = input.getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8888);
        socket.send(packet);
        //接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packetReceive = new DatagramPacket(buf, buf.length);
        socket.receive(packetReceive);
        //拆包
        int len = packetReceive.getLength();
        data = packetReceive.getData();
        String s = new String(data, 0, len);
        System.out.println(s);
        //关闭资源
        socket.close();
    }
}
