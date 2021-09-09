package 剑指offer_2.复杂链表的复制;

import java.util.HashMap;

public class Solution_1 {

    /**
     * map字典，遍历存储
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        HashMap<Node, Node> dicMap = new HashMap<Node, Node>();
        Node curr = head;
        while (curr != null) {
            dicMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            dicMap.get(curr).next = dicMap.get(curr.next);
            dicMap.get(curr).random = dicMap.get(curr.random);
            curr = curr.next;
        }

        return dicMap.get(head);
    }
}
