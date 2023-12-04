package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 */
public class Leetcode203 {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 =s.next;

        while(p2 != null){
            if(p2.val == val){
                p1.next = p2.next;
            }else{
                p1 = p2;
            }
            p2 = p2.next;
        }
        return s.next;
    }

    public static ListNode removeElements1(ListNode p, int val){
        if(p == null){
            return null;
        }

        if(p.val == val){
            return removeElements1(p.next,val);
        }else{
            p.next = removeElements1(p.next,val);
            return p;
        }

    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(5, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode node = removeElements(o1, 5);
        System.out.println(node);
    }
}
