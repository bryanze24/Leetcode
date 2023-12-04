package bryanze.datastructure.heap;

import bryanze.datastructure.linkedlist.ListNode;

public class MinHeap {

    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }


    public boolean offer(ListNode value){
        if(isFull()){
            return false;
        }

        int child = size;
        int parent = (child - 1) / 2;

        while (child > 0 && value.val < array[parent].val){
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        size++;
        return true;
    }

    public ListNode poll(){
        if(isEmpty()){
            return null;
        }
        swap(0, size - 1);
        size--;
        ListNode value = array[size];
        array[size] = null; //help GC
        //下潜
        dive(0);
        return value;
    }

    private void dive(int parent){
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent; //假设父元素优先级最低
        if(left < size && array[left].val < array[min].val){
            min = left;
        }

        if(right < size && array[right].val < array[min].val){
            min = right;
        }

        if(min != parent){ //有孩子优先级比父亲小
            swap(min, parent);
            dive(min);
        }
    }

    private void swap(int i, int j){
        ListNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }
}
