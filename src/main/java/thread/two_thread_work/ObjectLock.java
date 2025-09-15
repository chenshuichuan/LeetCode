package thread.two_thread_work;

public class ObjectLock {
    final static Object lock = new Object();
    private  static int count = 0;
    final static int MAX = 200;


    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while(count < MAX){
                    if(count % 2 == 0){
                        System.out.println(count);
                        count++;
                        lock.notify();
                    }
                    else{
                        try{
                            lock.wait();
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                while(count < MAX){
                    if(count % 2 == 1){
                        System.out.println(count);
                        count++;
                        lock.notify();
                    }
                    else{
                        try{
                            lock.wait();
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();

        //等待线程结束
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.print("-----main thread end----");
    }
}
