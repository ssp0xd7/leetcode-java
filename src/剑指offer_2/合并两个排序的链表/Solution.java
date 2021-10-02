package 剑指offer_2.合并两个排序的链表;

import util.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        //不为空的直接拼接上去
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
