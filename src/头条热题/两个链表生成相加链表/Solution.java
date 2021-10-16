package 头条热题.两个链表生成相加链表;

import util.ListNode;

public class Solution {

    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode n1 = reverse(head1);
        ListNode n2 = reverse(head2);
        ListNode dummyHead = new ListNode(-1);
        ListNode tmp = dummyHead;
        int c = 0;
        while (n1 != null || n2 != null) {
            int a = n1 == null ? 0 : n1.val;
            int b = n2 == null ? 0 : n2.val;
            int sum = a + b + c;

            tmp.next = new ListNode(sum % 10);
            c = sum / 10;
            tmp = tmp.next;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        if (c > 0) {
            tmp.next = new ListNode(c);
        }
        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode root) {
        ListNode pre = null, cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
