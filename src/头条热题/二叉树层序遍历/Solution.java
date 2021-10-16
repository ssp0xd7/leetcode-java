package 头条热题.二叉树层序遍历;

import util.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    /**
     * 边界，队列，记录每层数量
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(curList);
        }
        return ans;
    }
}
