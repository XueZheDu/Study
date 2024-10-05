package cam.gnkjxy.dome1.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    //化繁为简
    //1.完成显示菜单，并可以选择菜单，给出对应提示
    //2.完成零钱通明细
    //3.完成收益入账
    //4.完成消费

    //项目代码实现改进
    //1.用户输入4退出时，给出提示”你确定要退出吗？y/n",必须输入正确的y/n,否则循环输入指令，
    //  直到输入y或者n
    //2.在收益入账和消费时，判断金额是否合理，并给出相应的提示
    //3.将面向过程的代码修改成面向对象的方法，编写SmallChangeSysOOP.java类，
    //  井使用SmallChangeSysApp.java完成测试

    public static void main(String[] args) {

        //定义相关变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.完成零钱通明细
        //(1)可以把收益入账和消费，保存到数组 (2)可以使用对象 (3)简单的话可以使用String拼接
        //使用String拼接
        String details = "--------------零钱通明细--------------";

        //3.完成收益入账
        //定义新的变量
        double money = 0;
        double balance = 0;
        Date date = null;           //Date 是 java.util.Date 类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //4.完成消费
        //定义新变量，保存消费的原因
        String note = "";

        do {
            System.out.println("\n--------------零钱通菜单--------------");
            System.out.println("\t\t\t1. 零钱通明细");
            System.out.println("\t\t\t2. 收益入账");
            System.out.println("\t\t\t3. 消费");
            System.out.println("\t\t\t4. 退     出");

            System.out.print("请选择(1-4): ");
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    //money 的值应该校验
                    //找出不正确金额的条件，给出提示，直接 break
                    if (money <= 0) {
                        System.out.println("收益入账金额应大于0");
                        break;
                    }
                    balance += money;
                    //拼接收益入账信息到 details
                    date = new Date();  //获取当前日期
                    details +=  "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();
                    //money 的值应该校验
                    if (money <= 0 || money > balance) {
                        System.out.println("消费金额应大于0并且不大于余额(" + balance + ")");
                        break;
                    }
                    balance -= money;
                    System.out.print("消费说明：");
                    note = scanner.next();
                    //拼接消费信息到 details
                    date = new Date();  //获取当前日期
                    details +=  "\n" + note +"\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    //用户输入4退出时，给出提示”你确定要退出吗？y/n",必须输入正确的y/n,
                    //否则循环输入指令，直到输入y或者n
                    //定义一个变量 choice，接收用户的输入
                    String choice = "";
                    //使用 while + break，来处理接收到的输入是 y/n
                    while (true) {
                        System.out.println("你确定要退出吗？y/n");
                        choice = scanner.next();
                        if("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }
                    //退出 while 后，在判断接收到的是 y 或者 n
                    if (choice.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入");
            }
        }while (loop);

        System.out.println("-----------退出了零钱通项目------------");
    }

}
