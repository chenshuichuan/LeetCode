package thread.two_thread_work;

import java.util.concurrent.Semaphore;

public class TwoSemaphore {
    private static Semaphore evenSemaphore = new Semaphore(1);
    private static Semaphore oddSemaphore = new Semaphore(0);
    private static int count = 0;
    private final static int max = 100;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while(count < max){
                try{
                    evenSemaphore.acquire();
                    System.out.println(count);
                    count++;
                    oddSemaphore.release();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while(count < max){
                try{
                    oddSemaphore.acquire();
                    System.out.println(count);
                    count++;
                    evenSemaphore.release();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
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
