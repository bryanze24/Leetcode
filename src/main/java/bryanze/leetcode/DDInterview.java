package bryanze.leetcode;


import java.util.HashMap;

public class DDInterview {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next = new Node(cur.value, cur.next);

        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }

        Node newHead = head.next;
        Node cur = head;
        for (; cur.next.next != null; cur = cur.next) {
            Node node = cur.next;
            cur.next = node.next;
            node.next = node.next.next;
        }

        cur.next = null;
        return newHead;
    }

    class Node {
        int value;
        Node next;
        Node random;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
            this.next = null;
        }
    }
}
