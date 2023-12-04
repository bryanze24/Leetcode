package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

import java.util.HashSet;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @author lizelin
 */

public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode temp = headA;
        while(temp != null){
            hashSet.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while(temp != null){
            if(hashSet.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
