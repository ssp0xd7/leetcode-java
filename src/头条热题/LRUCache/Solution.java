package 头条热题.LRUCache;

import java.util.*;

public class Solution {

    public static int[] LRU(int[][] operators, int k) {
        // write code here
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int[] operator : operators) {
            int option = operator[0];
            int key = operator[1];

            if (option == 1) {
                int value = operator[2];
                dic.put(key, value);
                if (queue.contains(key)) {
                    queue.remove((Integer) key);
                }
                queue.addFirst(key);

                if (queue.size() > k) {
                    dic.remove(queue.getLast());
                    queue.removeLast();
                }
            } else {
                if (queue.contains(key)) {
                    list.add(dic.get(key));
                    if (queue.size() > 1) {
                        queue.remove((Integer) key);
                        queue.addFirst(key);
                    }
                } else {
                    list.add(-1);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,1,1},{1,1,2},{2,1}};
        LRU(a,3);
    }
}
