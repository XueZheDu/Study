package cam.gnkjxy.homework_hspJava.homework11;

import java.util.Scanner;

/*
编程题
（1）编写Java程序，输入形式为：Han Shun Ping的人名，以Ping,Han. S的形式打印
出来。其中.S是中间单词的首字母。
（2）例如输入"Willian Jefferson Clinton"，输出形式为：Clinton,willian .J
 */
public class Homework11_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        printName(name);
    }

    public static void printName(String str) {
        if (str == null) {
            System.out.println("输入不能为空");
            return;
        }

        String[] names = str.split(" ");
        if (names.length != 3) {
            System.out.println("输入的字符串格式错误");
            return;
        }

        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
