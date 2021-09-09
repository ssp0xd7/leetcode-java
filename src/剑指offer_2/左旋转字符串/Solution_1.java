package 剑指offer_2.左旋转字符串;

public class Solution_1 {

    /**
     * 模拟
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] leftPrefix = new char[n];
        char[] ans = new char[s.length()];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                leftPrefix[i] = chars[i];
            } else {
                ans[i - n] = chars[i];
            }
        }

        for (int i = chars.length - n; i < chars.length; i++) {
            ans[i] = leftPrefix[i + leftPrefix.length - chars.length];
        }

        return new String(ans);
    }
}
