package leetcode.二叉树的中序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_3 {

    /**
     * mirrors
     * 以某个根结点开始，找到它左子树的最右侧节点之后与这个根结点进行连接
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode cur1 = root;//当前开始遍历的节点
        TreeNode cur2 = null; //记录当前结点的左子树
        while (cur1 != null) {
            cur2 = cur1.left;
            //找到当前左子树的最右侧节点，且这个节点应该在指向根结点之前，否则整个节点又回到了根结点。
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) { //cur2.right != cur1表示还没有连接上
                    cur2 = cur2.right;
                }

                if (cur2.right == null) {
                    cur2.right = cur1; //连接上
                    cur1 = cur1.left; //cur1向左移动

                    continue;
                } else {
                    cur2.right = null; //cur2.right非空，表示之前已经连接过了，需要断开
                }
            }
            res.add(cur1.val);
            cur1 = cur1.right; //往回走，往右走
        }

        return res;
    }
}
