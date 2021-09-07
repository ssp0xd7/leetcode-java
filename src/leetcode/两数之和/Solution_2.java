package leetcode.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2 {

    /**
     * 运用hashmap的索引能力，降target当做key存储，value存储对应的数组下角标。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (targetMap.containsKey(target - nums[i])) {
                return new int[]{targetMap.get(target - nums[i]), i};
            }

            targetMap.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(Solution_2.twoSum(nums, target)));
    }
}
