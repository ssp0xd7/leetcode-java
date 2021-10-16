package 头条热题.最长公共子串;

public class Solution {

    public String LCS(String str1, String str2) {
        // write code here
        if (str1 == null || str2 == null) {
            return null;
        }

        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        int maxLength = 0;
        int lastIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        lastIndex = i;
                    }
                }
            }
        }
        return str1.substring(lastIndex - maxLength + 1, lastIndex + 1);
    }
}
