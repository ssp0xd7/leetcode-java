package 剑指offer_2.二叉树中和为某一值的路径;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<List<Integer>> ans = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return ans;
    }

    public void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }

        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }
}
