package 头条热题.大数加法;

public class Solution {

    public static String solve(String s, String t) {
        // write code here
        if (s.length() == 0 || t.length() == 0) {
            return null;
        }

        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int si = s.length() - 1;
        int ti = t.length() - 1;

        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (ti >= 0) {
            int temp = (s.charAt(si) - '0') + (t.charAt(ti) - '0') + c;
            sb.append(temp % 10);
            c = temp / 10;
            ti--;
            si--;
        }
        while (si >= 0) {
            int temp = c + (s.charAt(si) - '0');
            sb.append(temp % 10);
            c = temp / 10;
            si--;
        }
        if (c != 0) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("1", "99"));
    }
}
