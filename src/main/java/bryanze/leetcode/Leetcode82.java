package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给定一个已排序的链表的头 head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表 。
 */
public class Leetcode82 {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode sentinel = new ListNode(-101, head);
        ListNode p1 = sentinel;
        ListNode p2;
        ListNode p3;

        while((p2 = p1.next) != null && (p3 = p2.next) != null){
            if(p2.val == p3.val){
                while (p3 != null && p3.val == p2.val){
                    p3 = p3.next;
                }
                p1.next = p3;
            }else{
                p1 = p1.next;
            }
        }

        return sentinel.next;
    }


    public ListNode deleteDuplicates1(ListNode head) {

        // 若链表为空，或只有一个节点
        if(head==null || head.next==null){
            return head;
        }

        // 设置两个节点p、q，实际指向链表的是p.next、q.next
        // 时间复杂度为O(n)，实际上遍历所花的时间和一遍遍历差不多，虽然是两个while
        // temp节点是为了方便返回头节点
        ListNode temp = new ListNode(-1, head);
        ListNode p = temp;
        ListNode q = p.next;
        while(q != null && q.next != null){
            // 如果两个节点不相等，则都后移一个
            if(p.next.val != q.next.val){
                p = p.next;
                q = q.next;
            }
            // 如果两个节点相等，则将q节点后移，直到不相等即停，删除中间所有节点
            else{
                while(q.next != null && p.next.val == q.next.val){
                    q = q.next;
                }
                p.next = q.next;
                q = q.next;
            }
        }

        return temp.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode sentinel = new ListNode(-101, head);
        ListNode p1 = sentinel;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;

        while(p2 != null && p3 != null){
            if(p2.val == p3.val){
                while(p3 != null && p3.val == p2.val){
                    p3 = p3.next;
                }
                p1.next = p3;
            }else{
                p1 = p1.next;
            }
            p2 = p1.next;
            if(p2 != null){
                p3 = p2.next;
            }
        }

        return sentinel.next;
    }

    //递归实现
    public ListNode deleteDuplicates3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        if(head.val == head.next.val){
            ListNode p = head.next.next;
            while(p != null && p.val == head.val){
                p = p.next;
            }
            return deleteDuplicates3(p);

        }else{
            head.next = deleteDuplicates3(head.next);
            return head;
        }

    }


    public static void main(String[] args) {
            ListNode listNode = ListNode.of(1, 3, 3, 3, 4, 4, 4, 5, 5,6,6);
            System.out.println(listNode);
            System.out.println(new Leetcode82().deleteDuplicates3(listNode));
    }
}
