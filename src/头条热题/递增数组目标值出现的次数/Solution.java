package 头条热题.递增数组目标值出现的次数;

public class Solution {

    public static int findLen(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = find(nums, target, true);
        int right = find(nums, target, false);
        return right - left + 1;
    }

    private static int find(int[] nums, int target, boolean leftFlag) {
        int left = 0, right = nums.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                last = mid;
                //求左还是求右
                if (leftFlag) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return last;
    }



    public static void main(String[] args) {
        System.out.println(findLen(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
