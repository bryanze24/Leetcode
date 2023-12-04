package bryanze.datastructure.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestSinglyLinkedList {

    @Test
    @DisplayName("测试链表遍历")
    public void test1(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);

        linkedList.loop2(value ->{
            System.out.println(value);
        });
    }

    @Test
    @DisplayName("测试使用迭代器进行链表遍历")
    public void test2(){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);

        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试addLast")
    public void test3(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        Assertions.assertIterableEquals(Arrays.asList(1,2,3,4),list);

        int index = list.getValue(2);
        System.out.println(index);
    }

    @Test
    @DisplayName("测试insert")
    public void test4(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(0,5);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试removeFirst")
    public void test5(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试remove")
    public void test6(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.remove(2);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试递归遍历")
    public void test7(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.loop3(value ->{
            System.out.println("before:" + value);
        }, value ->{
            System.out.println("after:" + value);
        });
    }
}
