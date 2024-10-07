package cam.gnkjxy.homework_hspJava.homework4;

/**
 * 5.设计父类——员工类。子类:工人类,农民类,教师类,科学家类,服务生类。
 * (1)其中工人,农民,服务生只有基本工资
 * (2)教师除基本工资外还有课酬(元/天)
 * (3)科学家除基本工资外,还有年终奖
 * (4)编写一个测试类将各种类型的员工的全年工资打印出来
 */
public class Homework4 {
    public static void main(String[] args) {
        Worker worker = new Worker("jack", 7000);
        worker.printSal();

        Farmer farmer = new Farmer("ben", 8000);
        farmer.printSal();

        Server server = new Server("milan", 6000);
        server.printSal();

        Teacher teacher = new Teacher("aron", 6000);
        teacher.setClassDays(360);
        teacher.setClassSal(100);
        teacher.printSal();

        Scientist scientist = new Scientist("bob", 20000);
        scientist.setBonus(2000000);
        scientist.printSal();
    }
}
