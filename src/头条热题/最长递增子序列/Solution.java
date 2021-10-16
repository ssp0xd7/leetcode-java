package 头条热题.最长递增子序列;

public class Solution {

    public static int[] LIS(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] indexEndLen = new int[arr.length];

        int len = arr.length;
        int maxLen = 0;
        int left, right;
        for (left = 0; left < len; left++) {
            right = left;
            int curRight = arr[right];
            while (right < len) {
                if (arr[right] > curRight) {
                    curRight = arr[right];
                    if (right - left> maxLen) {
                        maxLen = right - left;
                        indexEndLen[right] = maxLen;
                    }
                }
                right++;
            }
        }
        int[] res = new int[maxLen];
        for (int i = indexEndLen.length - 1; i >= 0; --i) {
            if (indexEndLen[i] == len) {
                res[len - 1] = arr[i];
                --len;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LIS(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});
    }
}
