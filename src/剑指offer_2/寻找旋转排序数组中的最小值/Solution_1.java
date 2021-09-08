package 剑指offer_2.寻找旋转排序数组中的最小值;

public class Solution_1 {

    /**
     * 二分查找最小值
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                //相等时，忽略一位
                right--;
            }
        }
        return nums[left];
    }
}
