package leetcode.爬楼梯;

public class Solution_1 {

    /**
     * 动态规划
     * f(x)=f(x−1)+f(x−2)
     * 深度优先搜索，数组代替堆栈
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int[] climb = new int[n + 1];
        climb[0] = 1;
        climb[1] = 1;
        climb[2] = 2;
        for (int i = 3; i <= n; i++) {
            climb[i] = climb[i - 1] + climb[i - 2];
        }

        return climb[n];
    }

    public static void main(String[] args) {
        System.out.println(Solution_1.climbStairs(5));
    }
}
