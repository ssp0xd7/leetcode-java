package 剑指offer_2.斐波那契数列;

public class Solution_1 {

    /**
     * 递归不行
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return a;
    }
}
