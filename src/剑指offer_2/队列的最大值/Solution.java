package 剑指offer_2.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.removeLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            if (queue.peek().equals(deque.peekFirst())) {
                deque.removeFirst();
            }
            return queue.poll();
        }
    }
}
