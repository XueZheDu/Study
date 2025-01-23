package cam.gnkjxy.homework_hspJava.homework15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
2.编程题
要求:使用BufferedReader读取一个文本文件，为每行加上行号，
再连同内容一井输出到屏幕上。
 */
public class Homework15_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("d:\\mytemp\\hello.txt"));
        String line = "";
        int lineNum = 0;
        while((line = bf.readLine()) != null) {
            System.out.println(++lineNum + " " +line);
        }
        bf.close();
    }
}
