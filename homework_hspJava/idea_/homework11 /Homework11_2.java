package cam.gnkjxy.homework_hspJava.homework11;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
编程题
输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
要求：
（1）用户名长度为2或3或4
（2）密码长度为6，要求全是数字（isDigit）
（3）邮箱中包含@和.并且@在.的前面
 */
public class Homework11_2 {
    public static void main(String[] args) {
//        User user = new User();
//        System.out.println(user);

        String name = "jack";
        String pwd = "123456";
        String email = "jack@sohu.com";
        try {
            userRegister(name, pwd, email);
            System.out.println("恭喜你，注册成功~");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //老师答案
    public static void userRegister(String name, String pwd, String email) {
        //加入其他一些校验
        if (!(name != null && pwd != null && email != null)) {
            throw new RuntimeException("参数不能为null");
        }
        //1.检验用户名
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("用户名长度为2或3或4");
        }
        //2.检验密码
        if (!(pwd.length() == 6 && isDigit(pwd))) {
            throw new RuntimeException("密码长度为6，要求全是数字");
        }
        //3.检验邮箱
        int index1 = email.indexOf("@");
        int index2 = email.indexOf(".");
        if (!(index1 > 0 && index2 > index1)) {
            throw new RuntimeException("邮箱中包含@和.并且@在.的前面");
        }
    }
    //判断密码是否全为数字的方法
    public static boolean isDigit(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}

//我的答案
class User {
    private String name = "未命名";
    private int password = 123456;
    private String email = "空";

    public User() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("请输入用户名：");
            setName(scanner.next());
            System.out.print("请输入密码：");
            setPassword(scanner.nextInt());
            System.out.print("请输入邮箱：");
            setEmail(scanner.next());
        } catch (InputMismatchException e) {
            System.out.println("密码格式有误");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!(name.length() == 2 || name.length() == 3 || name.length() == 4)) {
            throw new RuntimeException("用户名长度错误");
        }
        this.name = name;
    }

    public void setPassword(int password) {
        String str = String.valueOf(password);
        if (str.length() != 6) {
            throw new RuntimeException("密码长度错误");
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!(email.indexOf("@") > 0 && email.indexOf("@") < email.indexOf("."))) {
            throw new RuntimeException("邮箱格式有误");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                '}';
    }
}
