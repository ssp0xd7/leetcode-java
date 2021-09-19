package 剑指offer_2.在排序数组中查找数字I;

public class Solution_1 {

    /**
     * 两轮二分查找，找到target左边界与右边界
     * right - left - 1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        // 搜索右边界 right
        while (i <= j) {
            int m = (j + i) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        //当前数组中无target
        if (j > 0 && nums[j] != target) {
            return 0;
        }
        //存储right
        int right = i;

        // 搜索左边界 right
        // 恢复i、j
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (j + i) / 2;
            //此处是 < 而不是 <=
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;

        return right - left - 1;
    }
}
