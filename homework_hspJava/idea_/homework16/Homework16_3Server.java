package cam.gnkjxy.homework_hspJava.homework16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
3.编程题
(1)编写客户端程序和服务器端程序
(2)客户端可以输入一个音乐文件名，比如高山流水，服务端收到音乐名后，可以给
客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐即可.
(3)客户端收到文件后，保存到本地d:\\
(4)提示:该程序可以使用StreamUtils.java
 */
public class Homework16_3Server {
    public static void main(String[] args) throws IOException {
        //监听9999端口，等待客户端连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待连接...");
        Socket socket = serverSocket.accept();
        //读取客户端发送的音乐文件名
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        String musicName = "";
        while ((len = inputStream.read(buf)) != -1) {
            musicName += new String(buf, 0, len);
        }
        System.out.println(musicName);
        //服务器有两个文件，高山流水.mp3 D大调小步舞曲.mp3
        //如果客户下载的文件是其中之一，则返回该文件，否则默认返回 D大调小步舞曲.mp3
        String resFileName = "";
        if ("高山流水".equals(musicName)) {
            resFileName = "src\\高山流水.mp3";
        } else {
            resFileName = "src\\D大调小步舞曲.mp3";
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        byte[] data = streamToByteArray(bis);
        //发送文件
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(data);
        socket.shutdownOutput();
        //关闭相关资源
        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
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
