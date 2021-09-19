package 剑指offer_2.在排序数组中查找数字I;

public class Solution_2 {

    /**
     * 两轮二分查找，找到target左边界与右边界
     * right - left - 1
     * <p>
     * 代码优化，转化为求 target与target-1的第一个右节点（因为原数组为升序数组）
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return searchTargetRight(nums, target) - searchTargetRight(nums, target - 1);
    }

    public int searchTargetRight(int[] nums, int target) {
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
        return i;
    }
}
