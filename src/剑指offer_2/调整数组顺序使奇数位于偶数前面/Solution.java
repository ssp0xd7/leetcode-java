package 剑指offer_2.调整数组顺序使奇数位于偶数前面;

public class Solution {

    public int[] exchange(int[] nums) {
        if (nums == null) {
            return new int[]{};
        }

        int i = 0, j = nums.length - 1;
        while (i < j) {

            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        return nums;
    }
}
