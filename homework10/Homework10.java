package cam.gnkjxy.homework_hspJava.homework10;

/*
1.编程题
a) 编写应用程序EcmDef.java，接收命令行的两个参数(整数)，计算两数相除。
b) 计算两个数相除，要求使用方法 cal(int n1, int n2)
c) 对数据格式不正确、缺少命令行参数、除0进行异常处理
 */
public class Homework10 {
}

class EcmDef {
    public static void main(String[] args) {

        try {
            //命令行输入的参数被args数组接收
            //先验证输入的参数个数是否正确
            if(args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数有误");
            }
            //将接收到的参数转成整数
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            //调用计算方法
            double res = cal(n1, n2); //可能抛出异常
            System.out.println("计算结果：" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("输入的数据格式不正确，应输入整数");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0...");
        }
    }

    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}