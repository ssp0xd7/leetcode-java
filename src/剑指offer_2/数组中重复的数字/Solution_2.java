package 剑指offer_2.数组中重复的数字;

public class Solution_2 {

    /**
     * 交换法
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            //当前索引位置对应值
            int temp = nums[i];
            //当前索引位置h值与nums[temp]互换
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;
    }
}
