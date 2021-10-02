package 剑指offer_2.第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    /**
     * linkedhashmap 有序存储，第二遍遍历直接找第一个不包含重复数据的字符
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<Character, Boolean>();
        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            dic.put(c, !dic.containsKey(c));
        }

        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }
}
