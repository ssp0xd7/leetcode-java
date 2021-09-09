package 剑指offer_2.左旋转字符串;

public class Solution_2 {

    /**
     * 取模
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] ans = new char[s.length()];
        char[] chars = s.toCharArray();

        for (int i = n; i < chars.length + n; i++) {
            ans[i - n] = chars[i % chars.length];
        }
        return new String(ans);
    }
}
