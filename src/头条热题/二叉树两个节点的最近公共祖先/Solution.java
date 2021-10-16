package 头条热题.二叉树两个节点的最近公共祖先;

import util.TreeNode;

public class Solution {

    //后续遍历，判断左右节点与根的关系
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        TreeNode p = new TreeNode(o1);
        TreeNode q = new TreeNode(o2);

        TreeNode res = ancestor(root, p, q);
        return res == null ? -1 : res.val;
    }

    //后续遍历，判断左右节点与根的关系
    private TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = ancestor(root.left, p, q);
        TreeNode right = ancestor(root.right, p, q);

        //p、q都不存在于当前子树
        if (left == null && right == null) {
            return null;
        }


        //p、q存在于左子树中
        if (right == null) {
            return left;
        }

        //p、q存在于右子树中
        if (left == null) {
            return right;
        }

        //p、q在root左右两侧，root为最近公共祖先
        return root; // (都非空)
    }
}
