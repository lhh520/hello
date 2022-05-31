import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class 信号量 {
    static class Producer implements Runnable {

        Semaphore mutex;
        Semaphore empty;
        Semaphore full;

        public Producer(Semaphore mutex, Semaphore empty, Semaphore full) {
            this.mutex = mutex;
            this.empty = empty;
            this.full = full;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("生产一些东西");
                    TimeUnit.SECONDS.sleep(1);
                    empty.acquire();
                    mutex.acquire();
                    System.out.println("将数据放入缓冲中");
                    TimeUnit.SECONDS.sleep(1);
                    mutex.release();
                    full.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //
    static class Consumer implements Runnable {
        Semaphore mutex;
        Semaphore empty;
        Semaphore full;

        public Consumer(Semaphore mutex, Semaphore empty, Semaphore full) {
            this.mutex = mutex;
            this.empty = empty;
            this.full = full;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    full.acquire();
                    mutex.acquire();
                    System.out.println("将数据从缓冲中取出");
                    TimeUnit.SECONDS.sleep(1);
                    mutex.release();
                    empty.release();
                    System.out.println("消费一些东西");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);
        Semaphore empty = new Semaphore(10);
        Semaphore full = new Semaphore(0);
        new Thread(new Producer(mutex, empty, full)).start();
        new Thread(new Consumer(mutex, empty, full)).start();
    }
}
