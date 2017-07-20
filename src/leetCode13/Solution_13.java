package leetCode13;

/**
 * Roman to Integer
 * </p>
 * Given a roman numeral, convert it to an integer.
 * </p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * </p>
 * 
 * @author kevin(ssp0xd7@gmail.com) 2017/7/20
 */
public class Solution_13 {

    public static int romanToInt(String s) {
        int sum = 0;
        int rightNum = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return toNumber(s.charAt(0));
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int currNum = toNumber(s.charAt(i));
            if (i == s.length() - 1) {
                sum += currNum;
            } else {
                if (currNum < rightNum) {
                    sum -= currNum;
                } else {
                    sum += currNum;
                }
            }
            rightNum = currNum;
        }
        return sum;
    }

    private static int toNumber(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Solution_13.romanToInt("V"));
    }
}
