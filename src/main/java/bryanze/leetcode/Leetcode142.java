package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 检测环的入口
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head; //兔子
        ListNode p2 = head; //龟
        while(p1 != null && p1.next != null){
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1 == p2){
                //进入第二阶段
                p2 = head;
                while(true){
                    if (p1 == p2) {
                        return p1;
                    }
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
        }
        return null;
    }
}
