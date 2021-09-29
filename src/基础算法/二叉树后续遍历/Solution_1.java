package 基础算法.二叉树后续遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {


    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        preorder(root.left, res);
        preorder(root.left, res);
        res.add(root.val);
    }
}
