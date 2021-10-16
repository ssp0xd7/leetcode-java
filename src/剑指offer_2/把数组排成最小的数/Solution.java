package 剑指offer_2.把数组排成最小的数;

public class Solution {

    /**
     * 拼接字符串 x + y > y + x ，则 x “大于” y ；
     * 反之，若 x + y < y + x，则 x “小于” y ；
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    /**
     * 快排
     *
     * @param strs
     * @param left
     * @param right
     */
    public void quickSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        String tmp = strs[i];
        while (i < j) {
            //有序移动
            while ((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j) {
                j--;
            }
            //有序移动
            while ((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j) {
                i++;
            }

            //不满足递增条件交换
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[left];
        strs[left] = tmp;

        quickSort(strs, left, i - 1);
        quickSort(strs, i + 1, right);
    }
}
