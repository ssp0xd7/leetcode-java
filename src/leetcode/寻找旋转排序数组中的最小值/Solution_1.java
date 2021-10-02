package leetcode.寻找旋转排序数组中的最小值;

public class Solution_1 {

    /**
     * 二分查找
     *
     * @param numbers
     * @return
     */
    public int findMin(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid+1;
            } else if (numbers[left] > numbers[mid]) {
                right = mid;
            } else {
                //相等时，忽略一位
                right--;
            }
        }
        return numbers[left];
    }
}
