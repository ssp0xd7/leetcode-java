package 剑指offer_2.栈的压入弹出序列;

import java.util.Stack;

public class Solution {

    /**
     * 判断压入弹出是否相等，循环出栈
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);

            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
