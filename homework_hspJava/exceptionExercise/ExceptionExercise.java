package cam.gnkjxy.dome1.exceptionExercise;

import java.util.Scanner;

/*
练习：
如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
 */
public class ExceptionExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr = "";
        while(true) {
            System.out.print("请输入一个整数: ");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr); //这里可能抛出异常
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入有误，请重新输入...");
            }
        }
        System.out.println("输入的整数为 " + num);
    }
}
