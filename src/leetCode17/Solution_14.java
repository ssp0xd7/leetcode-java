package leetCode14;

/**
 * Created by Kevin_Mit on 2017/3/16.
 */

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution_14 {

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String result = "";
        if (n == 0) {
            return "";
        }
        for (int pos = 0; pos < strs[0].length(); pos++) {
            for (int i = 1; i < n; i++) {
                if (strs[i].length() == pos || strs[i].charAt(pos) != strs[0].charAt(pos)) {
                    return strs[0].substring(0,pos);
                }
            }
            result = strs[0].substring(0, pos+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "ab", "ab", "ab"};
        System.out.println(Solution_14.longestCommonPrefix(strs));
    }
}
