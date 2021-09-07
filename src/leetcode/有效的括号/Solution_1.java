package leetcode.有效的括号;

import java.util.Stack;

public class Solution_1 {

    /**
     * 简单比较法，适用于复杂情况不高时，如本题只有三种括号。
     * 具体解法使用栈，遇到左括号入栈，遇到右括号出栈，同时判断是否是右括号对应的左括号。
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //非偶数长度直接返回
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (ch == ')') {
                        if (pop != '(') {
                            return false;
                        }
                    } else if (ch == '}') {
                        if (pop != '{') {
                            return false;
                        }
                    } else if (ch == ']') {
                        if (pop != '[') {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(Solution_1.isValid(s));
    }
}
