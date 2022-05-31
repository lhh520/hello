public class 等待通知机制 {
    private static Object obj = new Object();

    static class MyRunnableA implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 5; ++i) {
                    System.out.println("MyRunnableA: " + i);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }
    }
    //
    static class MyRunnableB implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 5; ++i) {
                    System.out.println("MyRunnableB: " + i);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new MyRunnableA(), "线程1").start();
        new Thread(new MyRunnableB(), "线程2").start();
    }
}
