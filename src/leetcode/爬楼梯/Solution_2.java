package leetcode.爬楼梯;

public class Solution_2 {

    /**
     * 动态规划
     * f(x)=f(x−1)+f(x−2)
     * 暴力深度优先搜索（会超时）
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

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Solution_2.climbStairs(3));
    }
}
