package 剑指offer_2.构建乘积数组;

public class Solution {

    public int[] constructArr(int[] a) {
        if (a == null) {
            return null;
        }
        if (a.length == 0) {
            return new int[0];
        }
        int len = a.length;
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
