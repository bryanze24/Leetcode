package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 */

public class Leetcode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p1 = list1;
        for (int i = 0; i < a - 1; i++) {
            p1 = p1.next;
        }

        ListNode p2 = p1;
        for (int i = 0; i < b - a + 2; i++) { //从第a - 1个到第b + 1个共需要遍历[(b+1) - (a - 1)]
            p2 = p2.next;
        }

        p1.next = list2;

        while(list2.next != null){
            list2 = list2.next;
        }

        list2.next = p2;
        return list1;
    }

    public ListNode mergeInBetween1(ListNode list1, int a, int b, ListNode list2){
        ListNode p1 = list1, p2 = list1;
        while(a > 1){
            p1 = p1.next;
            a--;
        }

        while (b > 0){
            p2 = p2.next;
            b--;
        }

        p1.next = list2;
        while(p1.next != null){
            p1 = p1.next;
        }
        p1.next = p2.next;
        p2.next = null;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(0, 1, 2, 3, 4, 5);
        ListNode list2 = ListNode.of(1000000, 1000001, 1000002);
        ListNode listNode = new Leetcode1669().mergeInBetween(list1, 3, 4, list2);
        System.out.println(listNode);

    }
}
