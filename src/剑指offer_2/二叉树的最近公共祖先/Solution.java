package 剑指offer_2.二叉树的最近公共祖先;

import util.TreeNode;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //p、q都不存在于当前子树
        if (left == null && right == null) {
            return null;
        }

        //p、q存在于右子树中
        if (left == null) {
            return right;
        }

        //p、q存在于左子树中
        if (right == null) {
            return left;
        }

        //p、q在root左右两侧，root为最近公共祖先
        return root;
    }
}
