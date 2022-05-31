public class 锁 {
    private static Object obj = new Object();
    static class MyA implements Runnable{
        @Override
        public void run() {
            for(int i=1;i<=100;i++){
                System.out.println("myA: "+i);
            }
        }
    }
    static class MyB implements Runnable{
        @Override
        public void run() {
            for(int i=1;i<=100;i++){
                System.out.println("myB: "+i);
            }
        }
    }
    public static void main(String[] args) {
        //线程A抢到锁之后减去100，B抢到锁再去减去100
        new Thread(new MyA(), "线程1").start();
        new Thread(new MyB(), "线程2").start();
    }
}
