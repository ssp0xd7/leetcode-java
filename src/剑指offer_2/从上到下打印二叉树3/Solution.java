package 剑指offer_2.从上到下打印二叉树3;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();

                if (level % 2 == 0) {
                    temp.add(head.val);
                } else {
                    temp.addFirst(head.val);
                }


                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }

            result.add(temp);
            level++;
        }

        return result;
    }
}
