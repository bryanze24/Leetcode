package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给定一个已排序的链表的头 head，删除所有重复的元素，使每个元素只出现一次。返回已排序的链表。
 */
public class Leetcode83 {

    //方法1
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = p1.next;

        while(p2 != null){
            if(p1.val == p2.val){
                p1.next = p2.next;
            }else{
                p1 = p2;
            }
            p2 = p2.next;
        }

        return head;
    }

    //方法2
    public ListNode deleteDuplicatesByRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        if(head.val == head.next.val){
            return deleteDuplicatesByRecursion(head.next);
        }else{
            head.next = deleteDuplicatesByRecursion(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.of(1, 3, 3, 3, 4, 4, 5);
        System.out.println(listNode);
        System.out.println(new Leetcode83().deleteDuplicates(listNode));
        System.out.println(new Leetcode83().deleteDuplicatesByRecursion(listNode));
    }
}
