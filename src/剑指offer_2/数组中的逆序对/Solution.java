package 剑指offer_2.数组中的逆序对;

public class Solution {


    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int left, int right) {
        if (left >= right) {
            return 0;
        }

        int m = (left + right) / 2;
        int res = mergeSort(left, m) + mergeSort(m + 1, right);

        // 合并阶段
        int i = left, j = m + 1;
        //暂存
        for (int k = left; k <= right; k++) {
            tmp[k] = nums[k];
        }

        for (int k = left; k <= right; k++) {
            if (i == m + 1) {
                nums[k] = tmp[j++];
            } else if (j == right + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}
