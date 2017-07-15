package leetCode7;

/**
 * 7. Reverse Integer
 * <p>
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Note: The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer
 * overflows.
 * <p>
 * Subscribe to see which companies asked this question.
 * <p>
 * 
 * @author kevin(ssp0xd7@gmail.com) 2017/3/14.
 */
public class Solution_7 {

    public static int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            int temp = x % 10;
            sum = sum * 10 + temp;
            if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
                //overflow return zero
                return 0;
            }
            x = x / 10;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(Solution_7.reverse(-222342343));
    }
}
