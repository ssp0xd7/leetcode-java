package 剑指offer_2.二叉搜索树的最近公共祖先;

import util.TreeNode;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) { //都在右子树
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {//都在左子树
                root = root.left;
            } else {
                break;
            }
        }

        return root;
    }
}
