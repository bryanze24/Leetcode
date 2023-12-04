package bryanze.datastructure.linkedlist;


import javafx.scene.shape.VLineTo;

import java.time.temporal.ValueRange;
import java.util.Iterator;

/**
 * 环形链表
 */
public class TwoWayCircularLinkedList implements Iterable<Integer>{


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = sentinel.next;

            @Override
            public boolean hasNext() {
                return pointer != sentinel;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public TwoWayCircularLinkedList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 添加到第一个
     * @param value 待添加值
     */
    public void addFirst(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到最后一个
     * @param value 待添加值
     */
    public void addLast(int value){
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除第一个
     */
    public void removeFirst(){
        Node removed = sentinel.next;
        if(removed == sentinel){
            throw new IllegalArgumentException("非法");
        }

        Node b = removed.next;
        sentinel.next = b;
        b.prev = sentinel;
    }

    /**
     * 删除最后一个
     */
    public void removeLast(){
        Node removed = sentinel.next;
        if(removed == sentinel){
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        a.next = sentinel;
        sentinel.prev = a;
    }


    public void removeByValue(int value){
        Node removed = findNodeByValue(value);
        if(removed == null){
            return; //不用删除
        }

        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }


    private Node findNodeByValue(int value){
        Node p = sentinel.next;

        while(p != sentinel){
            if(p.value == value){
                return p;
            }
            p = p.next;
        }

        return null;
    }

}
