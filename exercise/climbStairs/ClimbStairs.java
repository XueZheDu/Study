package cam.gnkjxy.exercise.climbStairs;

/*
有20阶楼梯，一次能爬一阶或两阶，一共有多少种爬法
思路分析：
1阶楼梯：1种
2阶楼梯：2种
3阶楼梯：先爬一阶，2种；先爬两阶，1种；一共3种
4阶楼梯：先爬一阶，3种；先爬两阶，2种；一共5种
...
...
n阶楼梯：先爬一阶，（n-1阶楼梯爬法总数）种；先爬两阶，（n-2阶楼梯爬法总数）种；一共（n-1阶楼梯爬法总数 + n-2阶楼梯爬法总数）种
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println("20阶楼梯一共有" + climbStairs(20) + "种爬法。");
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
