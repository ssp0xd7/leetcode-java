package 基础算法.对称二叉树;

import util.TreeNode;

import java.util.Stack;

public class Solution_2 {

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode n1, TreeNode n2) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(n1);
        stack.push(n2);

        while (!stack.isEmpty()) {
            n1 = stack.pop();
            n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }

            if ((n1 == null || n2 == null) || n1.val != n2.val) {
                return false;
            }

            stack.push(n1.left);
            stack.push(n2.right);

            stack.push(n1.right);
            stack.push(n2.left);
        }

        return true;
    }
}
