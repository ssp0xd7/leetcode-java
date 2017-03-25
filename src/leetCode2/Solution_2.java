package leetCode2;

/**
 * Created by Kevin_Mit on 2017/3/14.
 */
public class Solution_2 {

    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        while(l1 != null) {
            int sum =  carry + l1.val;
            current.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            current = current.next;
        }

        while(l2 != null) {
            int sum =  carry + l2.val;
            current.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            current = current.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode l1 = list1;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        ListNode l2 = list2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);
        ListNode listNode = Solution_2.addTwoNumbers(list1, list2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
