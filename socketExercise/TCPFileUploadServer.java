package cam.gnkjxy.dome1.socketExercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
网络上传文件
1.编写一个服务端，一个客户端
2.服务器端在8888端口监听
3.客户端连接到服务端，发送一张图片
4.服务器端接收到客户端发送的图片，保存到src下，发送“收到图片”再退出
5.客户端接收到服务端发送的“收到图片”，再退出
6.该程序要求使用StreamUtils.java内的方法
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        //服务器端再本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端再8888端口监听...");
        //等待连接
        Socket socket = serverSocket.accept();
        //读取客户端发送的数据，保存到字节数组中
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = streamToByteArray(bis);
        //将字节数组写入到指定路径
        String destFilePath = "src\\接收的文件.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);

        //向客户端回复“收到图片”
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush(); //把内容刷新到数据通道
        //设置结束标志
        socket.shutdownOutput();

        //关闭相关的流
        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
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
