package cam.gnkjxy.dome1.encap;

/*
    创建程序，在其中定义两个类:Account和AccountTest类体会Java的封装性。
    1.Account类要求具有属性:姓名(长度为2位3位或4位)、余额(必须>20)、密码(必须是六位)，
    如果不满足，则给出提示信息，并给默认值
    2.通过setXxx的方法给Account 的属性赋值。
    3.在AccountTest中测试
 */

public class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4){
            this.name = name;
        } else {
            System.out.println("长度必须为2位3位或4位");
            this.name = "无名客";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance > 20){
            this.balance = balance;
        } else {
            System.out.println("余额必须大于20");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() == 6){
            this.password = password;
        } else {
            System.out.println("密码必须是六位");
            this.password = "123456";
        }
    }

    public void getInfo() {
        System.out.println("姓名：" + getName() + " 余额：" + getBalance()
                + " 密码：" + getPassword());
    }
}
