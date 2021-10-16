package 头条热题.两数之和;

import java.util.*;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
        for (int i = 1; i <= numbers.length; i++) {
            int targetLeft = target - numbers[i - 1];
            if (targetMap.containsKey(targetLeft)) {
                int targetLeftIndex = targetMap.get(targetLeft);
                return targetLeftIndex > i ? new int[]{i, targetLeftIndex} : new int[]{targetLeftIndex, i};
            } else {
                targetMap.put(numbers[i - 1], i);
            }
        }
        return new int[0];
    }
}
