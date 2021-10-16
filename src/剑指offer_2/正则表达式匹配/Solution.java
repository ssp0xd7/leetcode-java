package 剑指offer_2.正则表达式匹配;


public class Solution {

    public boolean isMatch(String s, String p) {
        s = '0' + s;
        p = '0' + p;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;

        // 初始化首行
        for (int j = 2; j < n; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j) == '*';
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j) == '*') {
                    if (dp[i][j - 2]) {// *销毁前面的字符，出现0次
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && p.charAt(j - 1) == s.charAt(i)) {
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && p.charAt(j - 1) == '.') {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i - 1][j - 1] && s.charAt(i) == p.charAt(j)) {
                        dp[i][j] = true;
                    } else if (dp[i - 1][j - 1] && p.charAt(j) == '.') {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
