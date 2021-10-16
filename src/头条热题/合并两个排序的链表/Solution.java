package 头条热题.合并两个排序的链表;

import util.ListNode;

public class Solution {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(0);
        ListNode ans = head;
        ListNode p = list1;
        ListNode q = list2;
        while (p != null & q != null) {
            if (p.val > q.val) {
                head.next = q;
                q = q.next;
            } else {
                head.next = p;
                p = p.next;
            }
            head = head.next;
        }
        if (p == null) {
            head.next = q;
        }
        if (q == null) {
            head.next = p;
        }
        return ans.next;
    }
}
