package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

import java.util.Stack;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */

public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode temp = node;
        while(temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return node.next;
    }
    public ListNode swapPairs1(ListNode head) {
        //解法二：利用栈每次取出两个进行交换,时间复杂度O(n),空间复杂度O(1)
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = new ListNode(-1);
        ListNode cur = head;
        //让head指向p，返回的时候返回head.next就好了。
        head = p;
        Stack<ListNode> stack = new Stack<ListNode>();

        while (cur != null && cur.next != null) {
            stack.add(cur);
            stack.add(cur.next);
            cur = cur.next.next;
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        //不管cur是否为空都可以让p.next指向cur。
        //把这句放到循环里面反而内存消耗变大了。所以还是拿出来了。
        p.next = cur;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4);
        System.out.println(new Leetcode24().swapPairs1(head));
    }
}
