package cam.gnkjxy.myqq.qqclient.view;

import cam.gnkjxy.myqq.qqclient.service.FileClientService;
import cam.gnkjxy.myqq.qqclient.service.MessageClientService;
import cam.gnkjxy.myqq.qqclient.service.UserClientService;
import cam.gnkjxy.myqq.qqclient.utils.Utility;

/**
 * @author XueZheDu
 * @version 1.0
 * 客户端的菜单界面
 */
public class QQView {
    private boolean loop = true;  //控制是否显示菜单
    private String key = "";  //接收用户的键盘输入
    private UserClientService userClientService = new UserClientService(); //用于登入服务、注册用户等功能
    private MessageClientService messageClientService = new MessageClientService(); //用于私聊、群聊等功能
    private FileClientService fileClientService = new FileClientService(); //用于文件发送等功能

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统");
    }

    //显示主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("============欢迎登录网络通信系统============");
            System.out.println("\t\t\t1 登入系统");
            System.out.println("\t\t\t9 退出系统");
            System.out.print("请输入你的选择：");

            //根据用户的输入来处理不同的逻辑
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String password = Utility.readString(50);
                    //需要服务端验证该用户是否合法
                    if (userClientService.checkUser(userId, password)) { //如果合法
                        System.out.println("============欢迎（用户 " + userId + " ）============");
                        //进入二级菜单
                        while (loop) {
                            System.out.println("\n============网络通信系统菜单（用户 " + userId + " ）============");
                            System.out.println("\t\t\t1 显示在线用户列表");
                            System.out.println("\t\t\t2 群发消息");
                            System.out.println("\t\t\t3 私聊消息");
                            System.out.println("\t\t\t4 发送文件");
                            System.out.println("\t\t\t9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入想对大家说的话：");
                                    String s = Utility.readString(100);
                                    //调用方法发送群聊消息
                                    messageClientService.sendMessageToAll(s, userId);
                                    break;
                                case "3":
                                    System.out.print("请输入聊天对象的用户号：");
                                    String receiverId = Utility.readString(50);
                                    System.out.print("请输入聊天内容：");
                                    String content = Utility.readString(100);
                                    //调用方法发送私聊消息
                                    messageClientService.sendMessage(content, userId, receiverId);
                                    break;
                                case "4":
                                    System.out.print("请输入接收文件的用户号：");
                                    String receiverId2 = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径（格式 d:\\\\xx.png）：");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入接收文件的路径（格式 d:\\\\yy.png）：");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFile(src, dest, userId, receiverId2);
                                    break;
                                case "9":
                                    //需要给服务器发送一个退出系统的message
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("============登入失败============");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}