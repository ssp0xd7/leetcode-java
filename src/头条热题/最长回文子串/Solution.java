package 头条热题.最长回文子串;

public class Solution {

    public int getLongestPalindrome(String s, int n) {
        // write code here
        if (n < 2) {
            return s.length();
        }

        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int right = 1; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    continue;
                }

                if (right == left) {
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    //类似于"aa"和"aba"，也是回文子串
                    dp[left][right] = true;
                } else {
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[left][right] = dp[left + 1][right - 1];
                }
                //如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                }
            }
        }
        return maxLen;
    }
}
