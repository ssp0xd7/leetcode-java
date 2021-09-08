package 剑指offer_2.从尾到头打印链表;

import util.ListNode;

public class Soution_1 {

    /**
     * 反转链表简化版
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int[] res = new int[size];
        curr = head;
        while (curr != null) {
            res[size - 1] = curr.val;
            size--;
            curr = curr.next;
        }
        return res;
    }
}
