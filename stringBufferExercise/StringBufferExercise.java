package cam.gnkjxy.dome1.stringBufferExercise;

import java.util.Scanner;

/*
StringBuffer类课后练习2
输入商品名称和商品价格，要求打印效果示例，使用前面学习的方法完成：
商品名 商品价格
手机   123,564.59

要求：价格的1小数点前面每三位用逗号隔开
 */
public class StringBufferExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入商品名：");
        String str = scanner.next();
        System.out.print("请输入商品价格：");
        StringBuffer stringBuffer = new StringBuffer(scanner.next());
        //先找到 "." 的位置，从 "." 开始往前数，每三个数字插入一个 "," ，
        //如果没有找到 "," ，直接从个位开始(包括个位)，每三个数字插入一个 ","
        int index = stringBuffer.lastIndexOf(".");
        if (index == -1) {//如果没有找到 ","
            index = stringBuffer.length();
        }
        for (int i = index - 3; i > 0; i -= 3) {//1234567.89
            stringBuffer.insert(i, ",");
        }

        System.out.println("商品名\t商品价格\n" + str + "\t\t" + stringBuffer);

    }
}
