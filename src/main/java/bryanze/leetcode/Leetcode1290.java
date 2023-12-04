package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 */

public class Leetcode1290 {
    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            return head.val;
        }

        ListNode root = head;
        int count = 0;
        while (root != null) {
            root = root.next;
            count++;
        }

        int sum = 0;
        int i = count - 1;
        ListNode node = head;
        while (node != null) {
            sum += (int) (node.val * Math.pow(2, i));
            i--;
            node = node.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 0, 1);
        int value = new Leetcode1290().getDecimalValue(head);
        System.out.println(value);

    }
}
