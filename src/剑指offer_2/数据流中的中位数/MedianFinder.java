package 剑指offer_2.数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Integer> min_heap, max_heap;

    /**
     * min_heap    max_heap
     * max->min    min->max
     * initialize your data structure here.
     */
    public MedianFinder() {
        min_heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //升序
                return o1 - o2;
            }
        }); // 小顶堆，保存较大的一半
        max_heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //降序
                return o2 - o1;
            }
        }); // 大顶堆，保存较小的一半
    }

    /**
     * 如果两个数组相等：大顶堆+1
     * 不相等：小顶堆+1
     *
     * @param num
     */
    public void addNum(int num) {
        if (min_heap.size() != max_heap.size()) {
            min_heap.add(num);

            max_heap.add(min_heap.poll());
        } else {
            max_heap.add(num);

            min_heap.add(max_heap.poll());
        }
    }

    public double findMedian() {
        return min_heap.size() != max_heap.size() ? min_heap.peek() : (min_heap.peek() + max_heap.peek()) / 2d;
    }
}
