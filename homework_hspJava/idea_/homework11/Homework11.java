package cam.gnkjxy.homework_hspJava.homework11;

/*
编程题
（1）将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
（2）编写方法 public static String reverse(String str, int start, int end) 搞定
 */
public class Homework11 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("===交换前===");
        System.out.println(str);
        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("===交换后===");
        System.out.println(str);
    }
    public static String reverse(String str, int start, int end) {
        //对输入的参数做一个验证
        if(!(str != null && start < end && start >= 0 && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int left = start, right = end; left < right; left++, right--) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return new String(chars);
    }
}
