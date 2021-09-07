package leetcode.有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_2 {

    public static boolean isValid(String s) {
        //非偶数长度直接返回
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> dic = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (dic.containsKey(ch)) {
                //遇到右侧括号，但是栈为空，或者栈顶元素非配对
                if (stack.isEmpty() || stack.peek() != dic.get(ch)) {
                    return false;
                }

                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(Solution_2.isValid(s));
    }
}
