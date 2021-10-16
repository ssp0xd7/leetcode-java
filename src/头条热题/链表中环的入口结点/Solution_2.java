package 头条热题.链表中环的入口结点;

import util.ListNode;

public class Solution_2 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = pHead, slow = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                ListNode pHead2 = slow.next;
                slow.next = null;

                ListNode temp1 = pHead, temp2 = pHead2;
                while (temp1 != temp2) {
                    temp1 = temp1 == null ? pHead2 : temp1.next;
                    temp2 = temp2 == null ? pHead : temp2.next;
                }
                return temp1;
            }
        }
        return null;
    }
}
