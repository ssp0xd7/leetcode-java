package 剑指offer_2.丑数;

public class Solution {

    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            //最近最小的一个，通过x2或者x3或者x5得到的数
            dp[i] = Math.min(Math.min(n2, n3), n5);

            //命中的值加1，保持下次乘以2、3、5时，仍然是最小一个乘完大于dp[i-1]的数
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 89) {
            return false;
        }
        int temp = 0;
        while (n > 0) {
            temp += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(temp);
    }
}
