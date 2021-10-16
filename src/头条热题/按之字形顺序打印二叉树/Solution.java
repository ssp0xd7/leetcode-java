package 头条热题.按之字形顺序打印二叉树;

import util.TreeNode;

import java.util.*;

public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> tempAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    tempAns.add(node.val);
                } else {
                    tempAns.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
            ans.add(new ArrayList<Integer>(tempAns));
        }
        return ans;
    }

}
