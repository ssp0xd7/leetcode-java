package 剑指offer_2.把字符串转换成整数;

public class Solution {

    public int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int firstIndex = 0;
        int lastIndex = 0;
        char[] array = str.toCharArray();
        char first = array[firstIndex];
        int firstInt = first - '0';
        if (first == '+') {
            firstIndex++;
        } else if (first == '-') {
            firstIndex++;
            sign = -1;
        } else if (firstInt < 0 || firstInt > 9) {
            return 0;
        }

        for (int i = firstIndex; i < array.length; i++) {
            if (array[i] == 'e') {
                break;
            }
            int curr = array[i] - '0';
            if (curr < 0 || curr > 9) {
                break;
            }
            lastIndex = i;
        }
        if (firstIndex > lastIndex) {
            return 0;
        }

        long res = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            res = res * 10 + (array[i] - '0');
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }

        res *= sign;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
