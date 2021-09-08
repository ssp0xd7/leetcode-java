package 剑指offer_2.最小的k个数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1 {

    /**
     * 用大顶堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //大顶
                return o2 - o1;
            }
        });

        //先填满
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (queue.isEmpty()) {
                queue.add(arr[i]);
            } else {
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }
}
