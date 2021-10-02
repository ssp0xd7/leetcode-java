package 剑指offer_2.树的子结构;

import util.TreeNode;

public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    /**
     * 判断是否包含
     *
     * @param A
     * @param B
     * @return
     */
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
