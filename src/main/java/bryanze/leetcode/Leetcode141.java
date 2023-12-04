package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你一个链表的头节点 head，判断链表中是否有环。
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head; //兔子
        ListNode p2 = head; //龟
        while(p1 != null && p1.next != null){
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1 == p2){
                return true;
            }
        }
        return false;
    }
}
