package 剑指offer_2.把数字翻译成字符串;

public class Solution_2 {

    public int translateNum(int num) {
        String s = String.valueOf(num);

        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
