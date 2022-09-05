package plan92.线程;

public class ThreadTest11 {
    public static void main(String[] args) {
        System.out.println("最高优先级：" + Thread.MAX_PRIORITY);//最高优先级：10
        System.out.println("最低优先级:" + Thread.MIN_PRIORITY);//最低优先级:1
        System.out.println("默认优先级:" + Thread.NORM_PRIORITY);//默认优先级:5

        // main线程的默认优先级是：5
        System.out.println(Thread.currentThread().getName() + "线程的默认优先级是：" +Thread.currentThread().getPriority());

        Thread t = new Thread(new MyRunnable5());
        t.setPriority(10);
        t.setName("t");
        t.start();

        // 优先级较高的，只是抢到的CPU时间片相对多一些。
        // 大概率方向更偏向于优先级比较高的。
        for(int i = 0; i < 10000; i++){
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
class MyRunnable5 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
