package bryanze.datastructure.stack;

import bryanze.datastructure.stack.LinkedListStack;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedListStack {

    @Test
    public void push() {
        LinkedListStack<Object> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.push(4));

        assertIterableEquals(Arrays.asList(3, 2, 1), stack);
    }

    @Test
    public void pop() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 3, 2, 1
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }
}
