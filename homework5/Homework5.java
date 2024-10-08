package cam.gnkjxy.homework_hspJava.homework5;

/**
 * 8.扩展如下的BankAccount类
 * class BankAccount {
 *     private double balance;
 *     public BankAccount(double initialBalance) {
 *         this.balance = initialBalance;
 *     }
 *     public void deposit(double amount) {
 *         balance += amount;
 *     }
 *     public withdraw(double amount) {
 *         balance -= amount;
 *     }
 * }
 * 要求:
 * (1)在上面类的基础上扩展新类 CheckingAccount, 对每次存款和取款都收取1美元的手续费
 * (2)扩展前一个练习的 BankAccount 类，新类 SavingsAccount 每个月都有利息产生
 * (earnMonthlylnterest方法被调用)，并且有每月三次免手续费的存款或取款。
 * 在earnMonthlyinterest方法中重置交易计数
 */
public class Homework5 {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(10); // 1000 + 10 - 1 = 1009
        checkingAccount.withdraw(9); // 1009 - 9 - 1 = 999
        System.out.println(checkingAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance()); //1300
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance()); //1400 - 1 = 1399
        //月初
        savingsAccount.earnMonthlylnterest();
        System.out.println(savingsAccount.getBalance()); //1399 + 13.99 = 1412.99
        savingsAccount.withdraw(100); //免手续
        System.out.println(savingsAccount.getBalance()); //1412.99 - 100 = 1312.99
        savingsAccount.withdraw(100); //免手续
        savingsAccount.withdraw(100); //免手续
        System.out.println(savingsAccount.getBalance()); //1312.99 - 200 = 1112.99
        savingsAccount.deposit(100); //扣手续费
        System.out.println(savingsAccount.getBalance()); //1112.99 + 100 - 1 = 1211.99

    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}

class SavingsAccount extends BankAccount {
    private int count = 3;
    private double rate = 0.01;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        if (count > 0) {
           super.deposit(amount);
            count--;
        } else {
            super.deposit(amount - 1);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
            count--;
        } else {
            super.withdraw(amount + 1);
        }
    }

    public void earnMonthlylnterest() {
        super.deposit(getBalance() * rate);
        count = 3;
    }

}