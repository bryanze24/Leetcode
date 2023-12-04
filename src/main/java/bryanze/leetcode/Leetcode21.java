package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Leetcode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }else if (list2 == null ){
            return list1;
        }

        ListNode result = new ListNode(-101, null);
        ListNode p = result;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        p.next = list1 != null? list1 : list2;

        return result.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2){

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }

    }


    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1,2,4);
        ListNode list2 = ListNode.of(1,3,4);
        System.out.println(new Leetcode21().mergeTwoLists1(list1,list2));

    }
}
