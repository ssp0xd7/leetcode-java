package 剑指offer_2.用两个栈实现队列;

import java.util.Stack;

public class Solution_1 {

    class CQueue {

        private Stack<Integer> addStack;
        private Stack<Integer> delStack;

        public CQueue() {
            addStack = new Stack<Integer>();
            delStack = new Stack<Integer>();
        }

        public void appendTail(int val) {
            addStack.push(val);
        }

        public int deleteHead() {
            if (delStack.isEmpty()) {
                if (addStack.isEmpty()) {
                    return -1;
                } else {
                    while (!addStack.isEmpty()) {
                        delStack.push(addStack.pop());
                    }
                }
            }
            return delStack.pop();
        }
    }
}
