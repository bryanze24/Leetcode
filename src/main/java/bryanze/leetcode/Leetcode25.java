package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
 * 那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author lizelin
 * @date 2024/03/16
 */
public class Leetcode25 {

    //栈
    public ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode res = new ListNode(-1);
        ListNode p = res;

        while (true) {
            int count = 0;
            ListNode temp = head;

            while (temp != null && count < k) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }

            if (count != k) {
                p.next = head;
                break;
            }

            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }


            head = temp;

        }

        return res.next;
    }

    //尾插法
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;

        while (true) {

            int count = 0;
            while (tail != null && count != k) {
                tail= tail.next;
                count++;
            }

            if (tail == null) {
                break;
            }

            ListNode head1 = pre.next;

            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }

            pre = head1;
            tail = head1;

        }

        return dummy.next;
    }

}
