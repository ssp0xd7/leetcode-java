package 头条热题.合并两个有序的数组;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[j--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (j > 0) {
            A[k--] = B[j--];
        }
    }
}
