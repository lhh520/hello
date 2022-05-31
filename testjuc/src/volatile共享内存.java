import java.util.concurrent.TimeUnit;

public class volatile共享内存 {
    private static volatile boolean flag = true;

    static class MyRunnableA implements Runnable {
        @Override
        public void run() {
            System.out.println("start time: " + System.currentTimeMillis());
            while (flag) ;
            System.out.println("flag已被置为false");
            System.out.println("end time: " + System.currentTimeMillis());
        }
    }
    static class MyRunnableB implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("flag即将被置为false");
            flag = false;
        }
    }
    public static void main(String[] args) {
        new Thread(new MyRunnableA(), "线程1").start();
        new Thread(new MyRunnableB(), "线程2").start();
    }


}
