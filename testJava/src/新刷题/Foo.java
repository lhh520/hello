package 新刷题;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
   private AtomicInteger firstJobDone=new AtomicInteger(0);
   private AtomicInteger secondJobDone=new AtomicInteger(0);
   private final CountDownLatch firstDone;
   private final  CountDownLatch secondDone;
    public Foo() {
        firstDone=new CountDownLatch(1);
        secondDone=new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.countDown();
        //使用锁
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.countDown();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();
        while (secondJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
