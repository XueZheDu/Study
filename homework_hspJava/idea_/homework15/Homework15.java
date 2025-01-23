package cam.gnkjxy.homework_hspJava.homework15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
1.编程题
(1)在判断d盘下是否有文件夹mytemp如果没有就创建mytemp
(2)在d:\\mytemp目录下，创建文件hello.txt
(3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创健了
(4)并且在hello.txt文件中写入字符
 */
public class Homework15 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\mytemp");
        if (!file.exists()) {
            if(file.mkdir()) {
                System.out.println("mytemp创建成功");
            } else {
                System.out.println("mytemp创建失败");
            }
        }
        File file2 = new File("d:\\mytemp\\hello.txt");
        if (!file2.exists()) {
            if(file2.createNewFile()) {
                System.out.println("hello.txt创建成功");
                FileWriter fileWriter = new FileWriter(file2);
                fileWriter.write("hello,world!\n");
                fileWriter.write("我是练习两年半的Java练习生。\n");
                fileWriter.write("快和我一起卷Java吧!\n");
                fileWriter.close();
            } else {
                System.out.println("hello.txt创建失败");
            }
        } else {
            System.out.println("该文件已存在");
        }
    }
}
