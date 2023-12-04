package bryanze.datastructure.queue;


/**
 * 基于无序数组实现
 * @param <E> 队列中元素类型，必须实现Priority接口
 */
@SuppressWarnings("all")
public class PriorityQueue1<E extends Priority> implements Queue<E>{

    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        array[size] = value;
        size++;
        return true;
    }

    private int selectPriorityMax(){
        int max = 0;
        for (int i = 0; i < size; i++) {
            if(array[i].priority() > array[max].priority()){
                max = i;
            }
        }

        return max;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        int max = selectPriorityMax();
        E value = (E) array[max];
        remove(max);
        return value;
    }

    private void remove(int max) {
        if(max < size -1){
            System.arraycopy(array, max + 1, array, max,array.length - max - 1);
        }
        size--;
        array[size] = null;
    }


    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return (E) array[selectPriorityMax()];
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
