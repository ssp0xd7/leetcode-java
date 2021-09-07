package leetcode.爬楼梯;

public class Solution_3 {

    /**
     * 动态规划
     * f(x)=f(x−1)+f(x−2)
     * 深度优先搜索，滑动数组代替数组，减少空间
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int p = 1;
        int q = 2;
        int r = 0;

        for (int i = 3; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(Solution_3.climbStairs(5));
    }
}
