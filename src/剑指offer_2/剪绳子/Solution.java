package 剑指offer_2.剪绳子;

public class Solution {

    /**
     * dp[n] = Max(dp[i]*dp[n-i])
     *
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        int max, temp;
        //dp = [0][1][2][3][4][5][6][7][8][9]..[i];
        //         j    i-j
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(dp[i - j] * j, (i - j) * j);
                if (temp > max) {
                    max = temp;
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
