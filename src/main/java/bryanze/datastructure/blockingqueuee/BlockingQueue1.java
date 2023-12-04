package bryanze.datastructure.blockingqueuee;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单锁实现
 *
 * @param <E> 元素类型
 */
@SuppressWarnings("all")
public class BlockingQueue1<E> implements BlockingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private int size;

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition headWaits = lock.newCondition();
    private Condition tailWaits = lock.newCondition();


    @Override
    public void offer(E e) throws InterruptedException { //pool 等待队列非空
        lock.lockInterruptibly();

        try {
            while (isFull()) {
                tailWaits.await();
            }

            array[tail] = e;
            tail++;

            if (tail == array.length) {
                tail = 0;
            }

            size++;
            headWaits.signal();

        } finally {
            lock.unlock();
        }

    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {//毫秒
        lock.lockInterruptibly();

        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if(nanos <= 0){
                    return false;
                }

                nanos = tailWaits.awaitNanos(nanos);//等待时长，单位纳秒. 返回值代表剩余时间
            }

            array[tail] = e;
            tail++;

            if (tail == array.length) {
                tail = 0;
            }

            size++;
            headWaits.signal();
            return true;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {

        lock.lockInterruptibly();
        try {
            while(isEmpty()){
                headWaits.await();
            }

            E value = array[head];
            array[head] = null;  //help GC

            head++;
            if (head == array.length) {
                head = 0;
            }

            size--;
            tailWaits.signal();
            return value;

        } finally {
            lock.unlock();
        }

    }


    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

}
