package 头条热题.最长无重复子数组;

import java.util.*;

public class Solution {

    public int maxLength(int[] arr) {
        // write code here
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int left = 0, right = 0;
        while (right < arr.length) {
            while (set.contains(arr[right])) {
                set.remove(arr[left++]);
            }
            set.add(arr[right++]);
            max = Math.max(max, right - left);
        }
        return max;
    }
}
