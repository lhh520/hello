/**
 * @author 嘿嘿嘿1212
 * @version 1.0
 * @date 2020/1/31 19:48
 */
//主方法
public class TestProductorAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer pro = new Producer(clerk);
        Consumer cus = new Consumer(clerk);

        new Thread(pro,"生产者A").start();
        new Thread(cus,"消费者B").start();
    }
}
//仓库类
class Clerk {
    private int product = 0;

    //进货
    public synchronized void get() {
        if (product >= 10) {

            System.out.println("仓库已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            this.notify();
        }

    }

    //卖货
    public synchronized void sale() {
        if (product <= 0) {

            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            this.notify();//对其他的进城进行通知
        }

    }
}

//生产者类producer
class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

//消费者类
class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}

