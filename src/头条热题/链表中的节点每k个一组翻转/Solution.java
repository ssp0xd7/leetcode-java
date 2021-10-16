package 头条热题.链表中的节点每k个一组翻转;

import util.ListNode;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = dum, end = dum;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode newStart = end.next;
            ListNode start = pre.next;
            end.next = null;

            pre.next = reverseList(start);
            start.next = newStart;

            pre = start;
            end = start;
        }
        return dum.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
