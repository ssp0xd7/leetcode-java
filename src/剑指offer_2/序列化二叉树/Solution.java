package 剑指offer_2.序列化二叉树;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");

                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if (!vals[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}
