package 剑指offer_2.缺失的数字;

public class Solution_1 {

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 0 ;i<nums.length; i++){
            if (nums[i] > i) {
                return i;
            }
        }
        return nums.length;
    }
}
