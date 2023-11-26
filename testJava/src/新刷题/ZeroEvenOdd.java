package 新刷题;

import java.util.Objects;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Object o=new Object();
    private volatile int cur=0;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (o){
            if(cur%2==0){

            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    }
}
