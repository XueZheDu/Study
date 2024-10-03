package cam.gnkjxy.dome1.encap;

public class AccountTest {
    public static void main(String[] args) {
        //测试
        Account account1 = new Account("jack", 12000, "234567");
        account1.getInfo();
        Account account2 = new Account("名字非常长长长长长", 12, "1234");
        account2.getInfo();

    }
}
