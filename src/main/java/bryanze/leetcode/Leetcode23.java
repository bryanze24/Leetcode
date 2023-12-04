package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;
import bryanze.datastructure.heap.MinHeap;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        return split(lists, 0, lists.length - 1);
    }

    //返回合并后的链表，i，j代表左右边界
    private ListNode split(ListNode[] lists, int i, int j){
        if(i == j){
            return lists[i];
        }

        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return new Leetcode21().mergeTwoLists(left, right);
    }


    public ListNode mergeKLists1(ListNode[] lists){
        MinHeap heap = new MinHeap(lists.length);
        //将链表的头结点加入小顶堆
        for (ListNode h : lists) {
            if(h != null){
                heap.offer(h);
            }
        }
        //不断从堆顶移除最小元素，加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!heap.isEmpty()){
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            if(min.next != null){
                heap.offer(min.next);
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1,4,5),
                ListNode.of(1,3,4),
                ListNode.of(2,6)
        };
        System.out.println(new Leetcode23().mergeKLists1(lists));
    }
}
