package cam.gnkjxy.homework_hspJava.homework4;

public class Employee {
    private String name;
    private double salary;
    //分析有一个带薪月份 13薪 15薪 12薪
    private int salMonth = 12;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    //get和set方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getSalMonth() {
        return salMonth;
    }
    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    //打印全年工资
    public void printSal() {
        System.out.println(name + "的年工资：" + (salary * salMonth));
    }
}

class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.print("工人");
        super.printSal();
    }
}

class Farmer extends Employee {
    public Farmer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.print("农民");
        super.printSal();
    }
}

class Server extends Employee {
    public Server(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.print("服务员");
        super.printSal();
    }
}

class Teacher extends Employee {
    private int classDays;
    private double classSal;

    public Teacher(String name, double salary) {
        super(name, salary);
    }

    //get和set方法
    public int getClassDays() {
        return classDays;
    }
    public void setClassDays(int classDays) {
        this.classDays = classDays;
    }
    public double getClassSal() {
        return classSal;
    }
    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printSal() {
        System.out.println("老师" + super.getName() + "的年工资：" +
                (super.getSalary() * super.getSalMonth() + classDays * classSal));
    }
}

class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double salary) {
        super(name, salary);
    }

    //get和set方法
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSal() {
        System.out.println("科学家" + super.getName() + "的年工资：" +
                (super.getSalary() * super.getSalMonth() + bonus));
    }
}