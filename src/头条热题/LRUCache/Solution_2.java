package 头条热题.LRUCache;

import java.util.*;

public class Solution_2 {
    class LRUNode {
        private int key;
        private int value;

        private LRUNode pre;
        private LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        private Map<Integer, LRUNode> cache = new HashMap<Integer, LRUNode>();
        private LRUNode dummyHead;
        private LRUNode dummyTail;
        private int capacity;
        private int size;

        public LRUCache() {
        }

        public LRUCache(int capcaity) {
            this.size = 0;
            this.capacity = capcaity;
            this.dummyHead = new LRUNode();
            this.dummyTail = new LRUNode();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public void set(int key, int value) {
            LRUNode node = new LRUNode(key, value);
            if (cache.containsKey(key)) {
                node = cache.get(key);
                node.value = value;

                delete(node);
                addFirst(node);
            } else {
                if (size == capacity) {
                    LRUNode last = dummyTail.pre;
                    delete(last);
                    cache.remove(last.key);
                    size--;
                }
                addFirst(node);
                size++;
            }
            cache.put(key, node);
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                LRUNode node = cache.get(key);
                delete(node);
                addFirst(node);
                return node.value;
            } else {
                return -1;
            }
        }

        private void delete(LRUNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addFirst(LRUNode node) {
            node.next = dummyHead.next;
            node.next.pre = node;

            dummyHead.next = node;
            node.pre = dummyHead;
        }
    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        List<Integer> list = new ArrayList<Integer>();
        LRUCache cache = new LRUCache(k);
        for (int[] operator : operators) {
            int operation = operator[0];
            int key = operator[1];
            if (operation == 1) {
                int value = operator[2];
                cache.set(key, value);
            } else {
                list.add(cache.get(key));
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
