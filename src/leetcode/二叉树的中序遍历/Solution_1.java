package leetcode.二叉树的中序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    /**
     * 递归法，最简单
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
