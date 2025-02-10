package cam.gnkjxy.homework_hspJava.homework16;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework16_1Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //发送数据
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String input = scanner.next();
        writer.write(input);
        writer.flush();
        socket.shutdownOutput();
        //接收数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = reader.readLine();
        System.out.println(s);
        //关闭资源
        reader.close();
        writer.close();
        socket.close();
    }
}
