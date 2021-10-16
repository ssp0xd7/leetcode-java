package 头条热题.寻找第K大;

public class Solution {

    public int findKth(int[] a, int n, int K) {
        return quickFind(a, 0, n - 1, K);
    }

    private int quickFind(int[] a, int left, int right, int k) {
        int l = left, r = right;
        int temp = a[left];
        while (l < r) {
            while (l < r && temp > a[r]) {
                r--;
            }
            a[l] = a[r];
            while (l < r && a[l] > temp) {
                l++;
            }
            a[r] = a[l];
            a[l] = temp;
        }
        if (l == k - 1) {
            return a[l];
        } else if (l > k - 1) {
            return quickFind(a, l - 1, right, k);
        } else {
            return quickFind(a, left, l, k);
        }
    }
}
