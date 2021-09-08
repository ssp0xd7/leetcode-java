package leetcode.对称二叉树;

import util.TreeNode;

public class Solution_1 {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        return n1.val == n2.val && check(n1.left, n2.right) && check(n1.right, n2.left);
    }
}
