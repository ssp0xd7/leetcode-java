package 头条热题.数组中相加和为0的三元组;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 3) {
            return res;
        }
        // 对数组从小到大排序
        Arrays.sort(num);
        int length = num.length;
        for (int k = 0; k < length; k++) {
            // 如果相邻的两个元素相等，则直接跳过，防止重复
            if (k > 0 && num[k] == num[k - 1]) {
                continue;
            }
            // right 是右侧指针
            int right = length - 1;
            int temp = -num[k];
            // 从第一个元素后边开始遍历
            for (int left = k + 1; left < length; left++) {
                if (left > k + 1 && num[left] == num[left - 1]) {
                    continue;
                }
                while (right > left && num[right] + num[left] > temp) {
                    right--;
                }
                if (left == right) {
                    break;
                }
                if (num[left] + num[right] == temp) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[k]);
                    list.add(num[left]);
                    list.add(num[right]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
