package 头条热题.链表中环的入口结点;

import util.ListNode;

import java.util.*;

public class Solution {

    /**
     * a+x = nr = (n-1)*r + r= (n-1)*r + L - a
     * a = (n-1)r + L-a-x
     * L-a-x = 相遇到环入口
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode fast = pHead, slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //相遇
            if (fast == slow) {
                ListNode slow2 = pHead;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
