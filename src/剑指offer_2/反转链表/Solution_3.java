package 剑指offer_2.反转链表;

import util.ListNode;

import java.util.Stack;

public class Solution_3 {

    /**
     * 堆栈
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        //存进去
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        //取出来
        ListNode curr = stack.pop();
        //记录新head
        ListNode newHead = curr;
        //清空原来存储的不对的next
        curr.next = null;

        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
            curr.next = null;
        }
        return newHead;
    }
}
