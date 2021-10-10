package 剑指offer_2.数值的整数次方;

public class Solution {

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0d;
        }
        long exp = n;
        double res = 1.0;
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        while (exp > 0) {
            if (exp % 2 == 1) {
                res *= x;
            }
            x *= x;
            exp /= 2;
        }

        return res;
    }
}
