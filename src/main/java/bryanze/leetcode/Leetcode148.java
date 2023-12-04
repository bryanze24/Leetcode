package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你链表的头结点 head,请将其按 升序 排列并返回 排序后的链表 。
 */

public class Leetcode148 {
    //12ms
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> set = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            set.add(p.val);
            p = p.next;
        }

        Object[] array = set.toArray();
        Arrays.sort(array);

        ListNode result = new ListNode(-1000000);
        ListNode position = result;
        for (Object o : array) {
            position.next = new ListNode((Integer) o);
            position = position.next;


        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(4,l3);
        ListNode l5 = new ListNode(0,l4);
        ListNode listNode = new Leetcode148().sortList(l5);
        System.out.println(listNode.toString());
    }

}
