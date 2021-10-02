package leetcode.寻找两个正序数组的中位数;

public class Solution {

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            int len2 = nums2.length;
            return len2 % 2 == 0 ? (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2d : nums2[len2 / 2];
        } else if (nums2.length == 0) {
            int len1 = nums1.length;
            return len1 % 2 == 0 ? (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2d : nums1[len1 / 2];
        } else {
            int totalLen = nums1.length + nums2.length;
            if (totalLen % 2 == 0) {
                return (findTopK(nums1, nums2, totalLen / 2 - 1) + findTopK(nums1, nums2, totalLen / 2)) / 2d;
            } else {
                return findTopK(nums1, nums2, totalLen / 2);
            }
        }
    }

    public static int findTopK(int[] nums1, int[] nums2, int k) {
        int min = Integer.MAX_VALUE;
        int currentIndex = 0;

        int nums1Index = 0;
        int nums2Index = 0;

        while (currentIndex <= k) {
            if (nums1Index >= nums1.length) {
                min = nums2[nums2Index];
                nums2Index++;
                currentIndex++;
                continue;
            }

            if (nums2Index >= nums2.length) {
                min = nums1[nums1Index];
                nums1Index++;
                currentIndex++;
                continue;
            }
            if (nums1[nums1Index] < nums2[nums2Index]) {
                min = nums1[nums1Index];
                nums1Index++;
            } else {
                min = nums2[nums2Index];
                nums2Index++;
            }

            currentIndex++;
        }
        return min;
    }
}
