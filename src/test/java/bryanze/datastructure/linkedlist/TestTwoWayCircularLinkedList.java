package bryanze.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class TestTwoWayCircularLinkedList {

    @Test
    public void addFirst(){
        TwoWayCircularLinkedList list = new TwoWayCircularLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        assertIterableEquals(Arrays.asList(5,4,3,2,1),list);
    }

    @Test
    public void addLast(){
        TwoWayCircularLinkedList list = new TwoWayCircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        assertIterableEquals(Arrays.asList(1,2,3,4,5),list);
    }

}
