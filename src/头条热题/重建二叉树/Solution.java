package 头条热题.重建二叉树;

import util.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
        //递归调用的终止条件
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        //在中序遍历中找根结点位置，进行左右子树的划分
        for (int i = 0; i < inorder.length; i++) {
            //找到根节点
            if (root.val == inorder[i]) {
                //i为左子树长度
                root.left = reConstructBinaryTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
    }
}
