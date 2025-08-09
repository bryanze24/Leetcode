package bryanze.leetcode;

import java.util.concurrent.ConcurrentHashMap;

public class LRU {

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
        public LinkedNode(){

        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;


    private ConcurrentHashMap<Integer, LinkedNode> map = new ConcurrentHashMap<>();

    public LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = map.get(key);
        if (node == null){
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if (node == null) {
            LinkedNode linkedNode = new LinkedNode(key, value);
            map.put(key, linkedNode);
            addHead(linkedNode);
            size++;
            if (size > capacity) {
                LinkedNode deleteTail = removeTail();
                map.remove(deleteTail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private LinkedNode removeTail() {
        LinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
