package 剑指offer_2.复杂链表的复制;

import java.util.HashMap;

public class Solution_2 {

    private HashMap<Node, Node> dicMap = new HashMap<Node, Node>();

    /**
     * map字典，递归存储
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        if (dicMap.containsKey(head)) {
            return dicMap.get(head);
        }

        Node node = new Node(head.val);
        dicMap.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}
