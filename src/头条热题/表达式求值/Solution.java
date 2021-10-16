package 头条热题.表达式求值;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        solve("(3+4)*(5+(2-3))");
//        solve("1+2");
    }

    public static int solve(String s) {
        // write code here
        return eval(transToPostOrder(s));
    }

    private static List<String> transToPostOrder(String s) {
        List<String> ans = new ArrayList<String>();
        //优先级
        HashMap<String, Integer> map = new HashMap<>();
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);

        Stack<String> stack = new Stack<String>();
        int index = 0;
        while (index < s.length()) {
            String target = "";
            if (!Character.isDigit(s.charAt(index))) {
                target = s.charAt(index) + "";
                index++;
            } else {
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    target += s.charAt(index) + "";
                    index++;
                }
            }

            if (!map.containsKey(target)) {
                if (target.equals("(")) {
                    stack.push(target);
                } else if (target.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        ans.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    ans.add(target);
                }
            } else {
                if(stack.isEmpty()){
                    stack.push(target);
                }else{
                    String peek = stack.peek();
                    while (!stack.isEmpty() && !peek.equals("(") && map.get(stack.peek()) > map.get(target)) {
                        ans.add(stack.pop());
                    }
                    stack.push(target);
                }
            }
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private static int eval(List<String> tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
