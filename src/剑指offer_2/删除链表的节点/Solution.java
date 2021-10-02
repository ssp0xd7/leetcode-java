package 剑指offer_2.删除链表的节点;

import util.ListNode;

public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            head = head.next;
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        while (curr.val != val) {
            pre = curr;
            curr = curr.next;
        }

        pre.next = curr.next;

        return head;
    }
}
