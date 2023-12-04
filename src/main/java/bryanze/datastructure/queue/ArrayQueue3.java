package bryanze.datastructure.queue;

import jdk.jfr.events.ThrowablesEvent;

import java.util.Iterator;

public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    /*
        求模运算(二进制)
        - 如果除数是2的n次方
        - 那么被除数的后n位即为余数
        - 求被除数的后n位方法，与2^(n-1)按位与
     */


    private E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        /*
            如果capacity不是2的n次方
            解决方案：
                    1.抛异常
                    2.改成2的n次方
         */
        //判断capacity是不是2的n次方
//        1.抛异常
//        if((capacity & capacity - 1) != 0){
//            throw new IllegalArgumentException("capacity必须是2的n次方");
//        }
        capacity -= 1;
        capacity |= capacity >> 1;
        capacity |= capacity >> 2;
        capacity |= capacity >> 4;
        capacity |= capacity >> 8;
        capacity |= capacity >> 16;
        capacity += 1;
        array = (E[]) new Object[capacity];
    }


    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }

//        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        array[tail & array.length - 1] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

//        E value = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        E value = array[head & array.length - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return array[head & array.length - 1];
    }

    @Override
    public boolean isEmpty() {

        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p & array.length - 1];
                p++;
                return value;
            }
        };
    }
}
