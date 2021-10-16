package 头条热题.单链表的排序;

import util.ListNode;

public class Solution {

    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        ListNode left = sortInList(head);
        ListNode right = sortInList(next);

        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
