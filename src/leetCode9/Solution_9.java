package leetCode9;

/**
 * 9. Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the
 * reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 * <P>
 * 
 * @author kevin(ssp0xd7@gmail.com) 2017/3/15.
 */
public class Solution_9 {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int digit = 1;
        while (x / digit >= 10) {
            digit *= 10;
        }

        while (x != 0) {
            int left = x / digit;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % digit) / 10;
            digit /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = Solution_9.isPalindrome(123454321);
        System.out.println(palindrome);
    }
}
