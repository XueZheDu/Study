package cam.gnkjxy.homework_hspJava.homework16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
1.编程题
(1)使用字符流的方式，编写一个客户端程序和服务器端程序
(2)客户端发送“name”，服务器端接收到后，返回“我是nova”，nova是你自己的名字
(3)客户端发送“hobby”,服务器端接收到后，返回“编写java程序”
(4)不是这两个问题，回复“你说啥呢”
 */
public class Homework16_1Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端正在等待连接...");
        Socket socket = serverSocket.accept();
        //接收数据，并回复信息
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = reader.readLine();
        System.out.println(s);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        if (s.equals("name")) {
           writer.write("我是nova");
        } else if (s.equals("hobby")) {
            writer.write("编写java程序");
        } else {
            writer.write("你说啥呢");
        }
        writer.flush();
        socket.shutdownOutput();
        //关闭资源
        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
