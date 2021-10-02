package 剑指offer_2.二叉树的镜像;

import util.TreeNode;

public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        // 递归终止（不进行交换操作）
        if (root == null) return root;
        // 交换当前结点的左右子树
        swap(root);
        // 下一层递归
        mirrorTree(root.left);
        mirrorTree(root.right);
        // 递归返回
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;
    }
}
