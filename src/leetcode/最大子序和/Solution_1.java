package leetcode.最大子序和;

public class Solution_1 {

    /**
     * 动态规划
     *      f(i) = max{ f(i-1) + nums[i], nums[i] }
     *      求 max{ f(i) }
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int maxRes = nums[0];

        if (nums.length == 1) {
            return maxRes;
        }

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxRes = Math.max(pre, maxRes);
        }

        return maxRes;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Solution_1.maxSubArray(nums));
    }
}
