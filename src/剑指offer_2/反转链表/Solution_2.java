package 剑指offer_2.反转链表;

import util.ListNode;

public class Solution_2 {

    static class Solution {

        /**
         * 递归
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }
}
