package 剑指offer_2.二进制中1的个数;

public class Solution {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
