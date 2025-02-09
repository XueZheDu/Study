package cam.gnkjxy.dome1.socketExercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP网络通信编程
（使用字符流）
1.编写一个服务器端，和一个客户端
2.服务器端在9999端口监听
3.客户端连接到服务器端，发送“hello,server”，
并接收服务端回发的“hello,client”，再退出
4.服务器端接收到客户端发送的信息，输出，并发送“hello,client”，再退出
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //1.在本机的9999端口监听，等待连接（要求在本机没有其他服务器在监听）
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");
        //2.当没有客户端连接9999端口时，程序会阻塞，等待连接
        //  如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端Socket=" + socket.getClass());
        //3.通过socket.getInputStream()读取客户端写入到数据通道的数据，并显示
        InputStream inputStream = socket.getInputStream();
        //4.IO读取，使用字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //5.通过socket.getOutputStream()获取socket相关的输出流
        OutputStream outputStream = socket.getOutputStream();
        //6.写入数据到数据通道，使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client 字符流");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束
        bufferedWriter.flush();//需要手动刷新
        //7.关闭流和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
