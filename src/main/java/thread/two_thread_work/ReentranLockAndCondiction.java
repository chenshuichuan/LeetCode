package thread.two_thread_work;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockAndCondiction {
    private final static Lock lock = new ReentrantLock();
    private final static Condition oddCondition = lock.newCondition();
    private final static Condition evenCondition = lock.newCondition();
    private static int count = 0;
    private static int max = 200;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (count < max){
                    if (count % 2 == 0) {
                        System.out.println(count);
                        count++;
                        oddCondition.signal();
                    } else {
                        try {
                            evenCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                while (count < max){
                    if (count % 2 == 1) {
                        System.out.println(count);
                        count++;
                        evenCondition.signal();
                    } else {
                        try {
                            oddCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("-----main thread end----");


    }
}
