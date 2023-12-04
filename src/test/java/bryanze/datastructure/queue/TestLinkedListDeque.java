package bryanze.datastructure.queue;

import bryanze.datastructure.queue.LinkedListDeque;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedListDeque {

    @Test
    public void offer(){
        LinkedListDeque<Object> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        assertFalse(deque.offerLast(6));
        assertIterableEquals(Arrays.asList(3,2,1,4,5),deque);
    }

    @Test
    public void pool(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.pollFirst();
        assertIterableEquals(Arrays.asList(2,1,4,5),deque);
        deque.pollLast();
        assertIterableEquals(Arrays.asList(2,1,4),deque);
        Integer value = deque.peekFirst();
        assertEquals(2,value);
    }
}
