package 剑指offer_2.圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    /**
     * 模拟法
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }

        return list.get(0);
    }
}
