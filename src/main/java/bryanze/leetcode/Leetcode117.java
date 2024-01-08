package bryanze.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 *
 * @author lizelin
 * @date 2024/01/08
 */
public class Leetcode117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }

    public Node connect1(Node root) {

        if (root == null) {
            return null;
        }

        Node cur = root;

        while (cur != null) {
            Node dummy = new Node(-101);
            Node pre = dummy;

            while (cur != null) {

                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }

                if(cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }

                cur = cur.next;
            }

            cur = dummy.next;
        }

        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}