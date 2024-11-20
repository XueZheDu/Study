package cam.gnkjxy.homework_hspJava.homework11;

/*
编程题
输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
 */
public class Homework11_4 {
    public static void main(String[] args) {
        String str = "QWEasdf12345@";
        countStr(str);
    }

    public static void countStr(String str) {
        if (str == null) {
            return;
        }

        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;
        int otherCount = 0;
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCaseCount++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCaseCount++;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                digitCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("大写字母的数量：" + upperCaseCount);
        System.out.println("小写字母的数量：" + lowerCaseCount);
        System.out.println("数字的数量：" + digitCount);
        System.out.println("其他字符的数量：" + otherCount);
    }
}
