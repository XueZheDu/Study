package cam.gnkjxy.dome1.socketExercise;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        //客户端连接服务器，端口8888，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //将磁盘文件读取到程序里，用字节数组保存
        String filePath = "d:\\发送的文件.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = streamToByteArray(bis);
        //通过socket获取输出流，将bytes数组的数据发送到服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        //设置结束标志
        socket.shutdownOutput();

        //接收服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        String s = streamToString(inputStream); //用streamToString方法将读取到的内容转换成字符串
        System.out.println(s);

        //关闭相关的流
        inputStream.close();
        bos.close();
        bis.close();
        socket.close();
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

    //将InputStream转换成String
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\r\n");
        }
        return sb.toString();
    }
}
