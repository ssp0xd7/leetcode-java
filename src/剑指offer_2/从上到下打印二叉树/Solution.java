package 剑指offer_2.从上到下打印二叉树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();

            if (head.left != null) {
                queue.offer(head.left);
            }

            if (head.right != null) {
                queue.offer(head.right);
            }

            result.add(head.val);
        }
        int[] a = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            a[i] = result.get(i);
        }
        return a;
    }
}
