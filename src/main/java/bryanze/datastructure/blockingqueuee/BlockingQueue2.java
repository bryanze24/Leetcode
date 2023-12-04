package bryanze.datastructure.blockingqueuee;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双锁实现
 *
 * @param <E> 元素类型
 */

@SuppressWarnings("all")
public class BlockingQueue2<E> implements BlockingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size = new AtomicInteger(); //原子

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }


    //配对使用
    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();

    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();


    @Override
    public void offer(E e) throws InterruptedException { //pool 等待队列非空
        int c; //添加前元素个数
        tailLock.lockInterruptibly();

        try {
            while (isFull()) {
                tailWaits.await();
            }

            array[tail] = e;
            tail++;

            if (tail == array.length) {
                tail = 0;
            }

            c = size.getAndIncrement(); //size++

            if(c + 1< array.length){
                tailWaits.await();
            }

        } finally {
            tailLock.unlock();
        }

        if(c == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }

    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {//毫秒
        tailLock.lockInterruptibly();

        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (nanos <= 0) {
                    return false;
                }

                nanos = tailWaits.awaitNanos(nanos);//等待时长，单位纳秒. 返回值代表剩余时间
            }

            array[tail] = e;
            tail++;

            if (tail == array.length) {
                tail = 0;
            }

            size.getAndIncrement();

        } finally {
            tailLock.unlock();
        }
        headLock.lock();
        try {
            headWaits.signal();
        } finally {
            headLock.unlock();
        }

        return true;
    }

    @Override
    public E poll() throws InterruptedException {
        E value;
        int c; //取走前的元素个数
        headLock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }

            value = array[head];
            array[head] = null;  //help GC

            head++;
            if (head == array.length) {
                head = 0;
            }

            c = size.getAndDecrement(); // size--;

            if (c > 1) {
                headWaits.signal();
            }

        } finally {
            headLock.unlock();
        }

        if(c == array.length) {
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }

        return value;
    }


    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }
}
