package 剑指offer_2.数据流中的中位数;

import java.util.ArrayList;

public class MedianFinder_3 {

    private ArrayList<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder_3() {
        list = new ArrayList<Integer>();
    }

    /**
     * 插入
     *
     * @param num
     */
    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        int maxIndex = list.size() - 1;
        int pos = findPos(num);
        if (pos > maxIndex) {
            list.add(num);
        } else {
            list.add(findPos(num), num);
        }
    }

    public int findPos(int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (list.get(right) > num) {
            return right;
        } else {
            return right + 1;
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

    public static void main(String[] args) {
        MedianFinder_3 test = new MedianFinder_3();
        test.addNum(-1);
        test.addNum(-2);
        test.addNum(-3);
        System.out.println();
    }
}
