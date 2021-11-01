package 基础算法.阻塞队列;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockQueue {

    private volatile int size;
    private volatile int cap;
    private ArrayList<Integer> container = new ArrayList<>();

    private Lock lock = new ReentrantLock(false);

    private Condition isNull = lock.newCondition();
    private Condition isFull = lock.newCondition();

    public ArrayBlockQueue(int cap) {
        this.cap = cap;
    }

    public void add(int value) {
        try {
            lock.lock();
            try {
                while (size >= cap) {
                    isFull.await();
                }
                container.add(value);
                size++;

                isNull.signal();
            } catch (InterruptedException e) {
                isFull.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public Integer take() {
        try {
            lock.lock();
            try {
                while (size == 0) {
                    isNull.await();
                }
                Integer remove = container.remove(0);
                size--;
                isFull.signal();
                return remove;
            } catch (InterruptedException e) {
                isNull.signal();
            }
        } finally {
            lock.unlock();
        }

        return null;
    }
}
