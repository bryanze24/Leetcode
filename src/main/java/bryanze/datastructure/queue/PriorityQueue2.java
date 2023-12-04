package bryanze.datastructure.queue;


/**
 * 基于有序数组实现
 * @param <E> 队列中元素类型，必须实现Priority接口
 */
@SuppressWarnings("all")
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;


    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }


    //o(n)
    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    private void insert(E value) {
        int i = size - 1;
        while(i >= 0 && array[i].priority() > value.priority()){
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }

    //o(1)
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E value = (E) array[size - 1];
        array[size - 1] = null; //help GC
        size--;
        return value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
