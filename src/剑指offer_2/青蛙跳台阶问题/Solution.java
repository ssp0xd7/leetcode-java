package 剑指offer_2.青蛙跳台阶问题;

public class Solution {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 2, num = 0;
        for (int i = 3; i <= n; i++) {
            num = (a + b) % 1000000007;
            a = b;
            b = num;
        }
        return num;
    }
}
