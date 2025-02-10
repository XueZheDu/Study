package cam.gnkjxy.homework_hspJava.homework16;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework16_3Client {
    public static void main(String[] args) throws IOException {
        //接收用户输入，指定要下载的音乐名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要下载的音乐名");
        String musicName = scanner.next();
        //连接服务端，发送音乐名
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(musicName.getBytes());
        socket.shutdownOutput();
        //接收音乐文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] data = streamToByteArray(bis);
        //保存到本地磁盘
        String filePath = "d:\\" + musicName + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(data);
        //关闭相关资源
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }

    //将输入流读取的数据用字节数组保存
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = is.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] data = bos.toByteArray();
        bos.close();
        return data;
    }
}
