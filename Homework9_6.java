package cam.gnkjxy.homework_hspJava.homework9;

/*
枚举类
1.创健一个Color牧举类
2.有RED、BLUE、BLACK、YELLOW、GREEN这个五个枚举值/对像
3.Color有三个属性redValue，greenValue，blueValue
4.创建构造方法，参数包括这三个属性
5.每个枚举值都要给这三个属性赋值，三个属性对应的值分别是
  red: 255,0,0 blue: 0,0,255 black: 0,0,0 yellow: 255,255,0 green: 0,255,0
6.定义接口，里面有方法show，要求Color实现该接口
7.show方法中显示三属性的值
8.将枚举对象在switch语句中匹配使用
 */
public class Homework9_6 {
    public static void main(String[] args) {
        Color res = Color.YELLOW;

        //switch()中，放入枚举对象，在每个case后，直接写上枚举常量
        switch(res) {
            case RED:
                Color.RED.show();
                break;
            case BLUE:
                Color.BLUE.show();
                break;
            case BLACK:
                Color.BLACK.show();
                break;
            case YELLOW:
                Color.YELLOW.show();
                break;
            case GREEN:
                Color.GREEN.show();
                break;
            default:
        }
    }
}

interface IShowColorValue {
    void show();
}

enum Color implements IShowColorValue {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private final int redValue, greenValue, blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(name() + "的属性值为redValue: " + redValue + ", greenValue: " + greenValue +
                ", blueValue: " + blueValue);
    }
}