package 剑指offer_2.数据流中的中位数;

import java.util.ArrayList;

public class MedianFinder_2 {

    private ArrayList<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder_2() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        int right = list.size() - 1;
        while (right >= 0 && list.get(right) > num) {
            right--;
        }
        if (right < 0) {
            list.add(0, num);
        } else {
            list.add(right + 1, num);
        }
    }

    public double findMedian() {
        int len = list.size();
        if (len % 2 == 0) {
            return (list.get(len / 2 - 1) + list.get(len / 2)) / 2d;
        } else {
            return list.get(len / 2);
        }
    }
}
