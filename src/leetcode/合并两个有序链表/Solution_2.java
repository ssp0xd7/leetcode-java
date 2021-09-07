package leetcode.合并两个有序链表;

import util.ListNode;

public class Solution_2 {

    /**
     * 使用迭代法。
     * 建立哨兵节点prehead，同时维护一个prev指针。
     * 针对边界情况，当出现一个链表的next为空时，表示迭代结束。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }
        //prev.next等于l1、l2其中不为空节点，后面都是有序的
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
