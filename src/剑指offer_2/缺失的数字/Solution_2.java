package 剑指offer_2.缺失的数字;

public class Solution_2 {

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return i;
    }
}
