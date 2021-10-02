package 剑指offer_2.最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, temp = 0, len = s.length();
        for (int j = 0; j < len; j++) {

            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);

            //执行转移方程
            temp = temp < j - i ? temp + 1 : j - i;

            res = Math.max(res, temp);
        }

        return res;
    }

}