package cam.gnkjxy.dome1.enumExercise;

/**
 * 1.声明Week枚举类，其中包含星期一至星期日的定义
 * MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
 * 2.使用values返回所有的枚举数组，并遍历
 */
public class EnumExercise {
    public static void main(String[] args) {

        Week[] weeks = Week.values();
        System.out.println("===所有星期的信息如下===");
        for (Week week : weeks) {
            System.out.println(week);
        }
    }
}

enum Week {
    //定义枚举对象
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),
    THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");

    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}