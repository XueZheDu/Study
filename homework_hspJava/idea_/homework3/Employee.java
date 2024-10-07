package cam.gnkjxy.homework_hspJava.homework3;

//员工属性:姓名，单日工资，工作天数
//员工方法(打印工资)
public class Employee {
    private String name;
    private double salary_day;
    private int workDays;
    //分析出还有一个属性
    private double grade;

    public Employee(String name, double salary_day, int workDays, double grade) {
        this.name = name;
        this.salary_day = salary_day;
        this.workDays = workDays;
        this.grade = grade;
    }

    //get和set方法
    public double getSalary_day() {
        return salary_day;
    }
    public void setSalary_day(double salary_day) {
        this.salary_day = salary_day;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWorkDays() {
        return workDays;
    }
    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    //打印工资
    public void printSalary() {
        System.out.println(name + "的工资：" + salary_day * workDays * grade);
    }
}

class Manager extends Employee {
    private double bonus;

    //创建对象时，奖金不确定，通过setBonus()方法赋值
    public Manager(String name, double salary_day, int workDays, double grade) {
        super(name, salary_day, workDays, grade);
    }

    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("部门经理" + super.getName() + "的工资：" + (bonus + super.getSalary_day()
                * super.getWorkDays() * super.getGrade()));
    }
}

class Worker extends Employee {
    public Worker(String name, double salary_day, int workDays, double grade) {
        super(name, salary_day, workDays, grade);
    }

    @Override
    public void printSalary() {
        System.out.print("普通员工");
        super.printSalary();
    }
}
