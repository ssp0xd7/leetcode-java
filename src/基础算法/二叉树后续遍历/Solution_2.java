package 基础算法.二叉树后续遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_2 {

    /**
     * 迭代法，用堆栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curr = root;
        TreeNode done = null;
        
        while (curr != null || !stack.isEmpty()) {
            //左侧都入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if (curr.right != null && curr.right != done) {
                curr = curr.right;
                continue;
            }

            curr = stack.pop();
            res.add(curr.val);
            done = curr;
            curr = null;
        }

        return res;
    }
}
