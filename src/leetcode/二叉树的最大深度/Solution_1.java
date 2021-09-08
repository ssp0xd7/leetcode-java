package leetcode.二叉树的最大深度;

import util.TreeNode;

public class Solution_1 {

    /**
     * 递归，深度优先
     * H = max(H(left), H(right)) +1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHight = maxDepth(root.left);
            int rightHight = maxDepth(root.right);

            return Math.max(leftHight, rightHight) + 1;
        }
    }
}
