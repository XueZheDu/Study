package cam.gnkjxy.dome1.socketExercise;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
1.编写一个接收端A和一个发送端B
2.接收端A在9999端口等待接收数据（receive）
3.发送端B向接收端A发送数据“hello，明天吃火锅~”
4.接收端A接收到发送端B发送的数据，回复“好的，明天见”，再退出
5.发送端接收回复的数据，再退出
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象。准备在9999端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建一个DatagramPacket对象，准备接收数据
        byte[] buf = new byte[1024]; //数据包最大为64K，即64*1024字节
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.调用接收方法，通过网络传输的DatagramPacket对象填充到接收端A的packet对象
        System.out.println("接收端A等待接收数据...");
        socket.receive(packet); //当有数据包发送到本机的9999端口时，就会接收数据，如果没有就阻塞等待
        //4.将packet拆包，取出数据并显示
        int length = packet.getLength(); //实际接收到的数据长度
        byte[] data = packet.getData(); //接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);
        //5.发送回复信息
        byte[] sendData = "好的，明天见".getBytes();
        DatagramPacket packetSend =
                new DatagramPacket(sendData, sendData.length, packet.getAddress(), packet.getPort());
        socket.send(packetSend);
        //6.关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
