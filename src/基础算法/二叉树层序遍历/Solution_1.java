package 基础算法.二叉树层序遍历;

import util.TreeNode;

import java.util.*;

public class Solution_1 {

    /**
     * 二叉树层序遍历，利用队列
     *
     * @param root
     */
    public static List<Integer> layerTranvrse(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }

            res.add(head.val);
        }

        return res;
    }
}
