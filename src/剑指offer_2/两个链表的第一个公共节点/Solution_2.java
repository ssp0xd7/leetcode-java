package 剑指offer_2.两个链表的第一个公共节点;

import util.ListNode;

public class Solution_2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lena = 0, lenb = 0;
        ListNode a = headA, b = headB;

        while (a != null) {
            lena++;
            a = a.next;
        }
        while (b != null) {
            lenb++;
            b = b.next;
        }

        int d = lena - lenb;
        if (d > 0) {
            while (d-- > 0) {
                headA = headA.next;
            }
        } else {
            d = -d;
            while (d-- > 0) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
