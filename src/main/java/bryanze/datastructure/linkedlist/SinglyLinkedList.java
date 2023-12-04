package bryanze.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer>{

    private Node head = null; //头指针

    /**
     * 迭代器遍历
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {

        //匿名内部类
        return new Iterator<Integer>() {

            Node pointer = head;
            @Override
            public boolean hasNext() { //是否有下一个元素
                return pointer != null;
            }

            @Override
            public Integer next() { //返回当前元素值,并且指向下一个元素
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }


    /**
     * 节点类
     */

   private static class Node{

        int value; //值

        Node next; //下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     * @param value 待添加值
     */
    public void addFirst(int value){
        //1和2可以合并为链表非空的形式，因为当链表为空的时候head = null;

       //1.链表为空
//        head = new Node(value, null);

        //2.链表非空
        head = new Node(value, head);
    }


    /**
     * while循环遍历链表
     */
    public void loop1(Consumer<Integer> consumer){
        Node pointer = head;
        while(pointer != null){
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    /**
     * for循环遍历链表
     */
    public void loop2(Consumer<Integer> consumer){
        for(Node pointer = head; pointer != null; pointer = pointer.next){
            consumer.accept(pointer.value);
        }

    }

    /**
     * 递归遍历链表
     */
    public void loop3(Consumer<Integer> before,
                      Consumer<Integer> after){
        recursion(head,before,after);
    }

    /**
     * 递归方法
     *
     * @param curr   要操作的节点
     * @param before
     * @param after
     */
    private void recursion(Node curr,
                           Consumer<Integer> before,
                           Consumer<Integer> after){ //针对某个节点要进行的操作
        if(curr == null){
            return;
        }
        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }


    /**
     * 找到最后一个节点
     * @return 返回结果
     */
    private Node findLast(){
        if(head == null){
            return null;
        }

        Node pointer;
        for(pointer = head; pointer.next != null; pointer = pointer.next){

        }

        return pointer;
    }

    /**
     * 向链表尾部添加
     * @param value 待添加值
     */
    public void addLast(int value){
        Node last =findLast();
        if(last == null){ //空链表
            addFirst(value);
            return;
        }
        last.next = new Node(value,null);
    }

    /**
     * 根据索引位置返回节点对象
     * @param index 索引
     * @return 节点对象
     */
    private Node findNode(int index){
        int i = 0;
        for(Node p = head; p != null; p = p.next, i++){
            if(i == index){
                return p;
            }
        }
        return null; //没有找到的情况
    }

    /**
     * 根据索引位置返回值
     * @param index 索引
     * @return 链表在该节点的值
     * @throws IllegalArgumentException 找不到，抛出索引index非法异常
     */
    public int getValue(int index){
        Node node = findNode(index);
        if(node == null){
            throw illegalIndex(index);
        }
        return node.value;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法", index));
    }

    /**
     * 向索引位置插入
     * @param index 索引位置
     * @param value 待插入值
     */
    public void insert(int index, int value){
//        Node node_q = findNode(index - 1);
//        Node node_h = findNode(index);
//        Node node_insert = new Node(value,null);
//        node_insert.next = node_h;
//        node_q.next = node_insert;
        if(index == 0){
            addFirst(value);
            return;
        }
        Node prevNode = findNode(index - 1); //找到上一个节点
        if(prevNode == null){
            throw illegalIndex(index);
        }

        prevNode.next = new Node(value, prevNode.next);
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst(){
        if(head == null){
            throw illegalIndex(0);
        }
        head = head.next;
    }


    /**
     * 删除指定索引位置的节点
     * @param index 索引
     */
    public void remove(int index){

        if(index == 0){
            removeFirst();
            return;
        }

        Node prevNode = findNode(index - 1); //上一个节点
        if(prevNode == null){
            throw illegalIndex(index);
        }

        Node removeNode = findNode(index); //被删除的节点
        if(removeNode == null){
            throw illegalIndex(index);
        }

        prevNode.next = removeNode.next;
    }

}
