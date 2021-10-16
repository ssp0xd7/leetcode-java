package 剑指offer_2.打印从1到最大的n位数;

public class Solution {

    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        recur(0);
        return res;
    }

    public void recur(int x) {
        // 终止条件：已固定完所有位
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {
                res[count++] = Integer.parseInt(s);
            }
            if (n - start == nine) {
                start--;
            }
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            recur(x + 1);
        }
        nine--;
    }
}
