package 剑指offer_2.二叉搜索树与双向链表;

import util.TreeNode;

public class Solution {

    private TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        recur(root);

        head.left = pre;
        pre.right = head;
        return head;
    }

    private void recur(TreeNode root) {
        if (root == null) {
            return;
        }

        recur(root.left);
        if (pre != null) { //非第一个节点
            pre.right = root;
        } else { //root为双向链表第一个节点
            head = root;
        }
        root.left = pre;
        pre = root;

        recur(root.right);
    }
}
