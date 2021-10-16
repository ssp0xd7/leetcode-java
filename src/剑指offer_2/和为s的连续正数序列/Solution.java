package 剑指offer_2.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 双指针
     * left，right
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if (sum == target) {
                int[] ans = new int[right - left + 1]; // 左右都包含
                for (int i = left; i <= right; i++) {
                    ans[i - left] = i;
                }
                res.add(ans);
            }
            if (sum > target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
