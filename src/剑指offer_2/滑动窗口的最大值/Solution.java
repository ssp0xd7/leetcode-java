package 剑指offer_2.滑动窗口的最大值;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int currMax = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                if (nums[i + j] > currMax) {
                    currMax = nums[i + j];
                }
            }
            ans[i] = currMax;
        }
        return ans;
    }
}
