package 剑指offer_2.反转链表;

import util.ListNode;

public class Solution_1 {

    static class Solution {

        /**
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode next = curr.next;

                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }
}
