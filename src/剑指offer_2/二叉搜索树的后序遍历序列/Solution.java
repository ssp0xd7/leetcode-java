package 剑指offer_2.二叉搜索树的后序遍历序列;

public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int rightFirst = left;
        while (postorder[rightFirst] < postorder[right]) {
            rightFirst++;
        }
        int rightFirstCopy = rightFirst;
        //找到第一个不大于根节点的节点，看是否为根节点
        while (postorder[rightFirst] > postorder[right]) {
            rightFirst++;
        }
        boolean verifyCurrent = rightFirst == right;
        boolean isLeftVerify = recur(postorder, left, rightFirstCopy - 1);
        boolean isRightVerify = recur(postorder, rightFirstCopy, right - 1);
        return verifyCurrent && isLeftVerify && isRightVerify;
    }
}
