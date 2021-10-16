package 剑指offer_2.字符串的排列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    List<String> ans = new LinkedList<>();
    char c[];

    public String[] permutation(String s) {
        c = s.toCharArray();
        recur(0);
        return ans.toArray(new String[ans.size()]);
    }

    public void recur(int x) {
        if (x == c.length - 1) {
            //新方案
            ans.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);//新的固定值

            swap(i, x);
            recur(x + 1);
            swap(i, x);
        }
    }

    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }
}
