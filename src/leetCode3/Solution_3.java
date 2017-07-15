package leetCode3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters Given a string, find the length of the longest substring without
 * repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * <p>
 * Subscribe to see which companies asked this question.
 * <p>
 * 
 * @author kevin(ssp0xd7@gmail.com) 2017/3/14.
 */
public class Solution_3 {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int maxLength = 0;
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            for (int j = i; j < sLength; j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    if (set.size() > maxLength) {
                        maxLength = set.size();
                    }
                    set.clear();
                    break;
                }
            }
        }
        return maxLength > set.size() ? maxLength : set.size();
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(Solution_3.lengthOfLongestSubstring(s));
    }
}
