package cam.gnkjxy.homework_hspJava.homework2;

/**
 * 3.编写老师类
 * (1)要求有属性“姓名name”，“年龄age”，“职称post”，“基本工资salary”
 * (2)编写业务方法，introduce()，实现输出一个教师的信息
 * (3)编写教师类的三个子类:教授类、副教授类、讲师类。工资级别分别为:教授为1.3、副教授为1.2、讲师类1.1。
 * 在三个子类里面都重写父类的introduce()方法
 * (4)定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印
 */
public class Homework2 {
    public static void main(String[] args) {
        Professor professor = new Professor("小明", 27, "高级职称", 30000, 1.3);
        professor.introduce();
    }
}
