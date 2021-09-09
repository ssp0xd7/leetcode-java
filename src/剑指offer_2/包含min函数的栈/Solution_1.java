package 剑指offer_2.包含min函数的栈;

import java.util.LinkedList;

public class Solution_1 {


    class MinStack {
        LinkedList<Integer> stack, minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
        }

        public void push(int x) {
            stack.addLast(x);

            if (minStack.isEmpty() || minStack.getLast() >= x) {
                minStack.addLast(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int temp = stack.removeLast();
                if (!minStack.isEmpty() && minStack.getLast() == temp) {
                    minStack.removeLast();
                }
            }
        }

        public int top() {
            //可以不判空
            return stack.getLast();
        }

        public int min() {
            return minStack.getLast();
        }
    }
}
