package cam.gnkjxy.dome1.socketExercise;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP网络通信编程
1.编写一个服务器端，和一个客户端
2.服务器端在9999端口监听
3.客户端连接到服务器端，发送“hello,server”，然后退出
4.服务器端接收到客户端发送的信息，输出，并退出
 */
public class SocketTCP01Server {
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
        //4.IO读取
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0 , readLen));
        }
        //5.关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
