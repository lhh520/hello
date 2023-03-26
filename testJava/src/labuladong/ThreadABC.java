package labuladong;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadABC {
    private static int state=0;

    public static void main(String[] args) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        final Lock lock=new ReentrantLock();

        Thread A=new Thread(new Runnable() {
            @Override
            public void run() {
                while (state<=30) {
                    lock.lock();//get lock
                    if (state%3==0) {
                        System.out.print("A");
                        state++;
                    }
                    lock.unlock();//release lock
                }
            }
        });

        Thread B=new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (state<=30) {
                    lock.lock();//get lock
                    if (state%3==1) {
                        System.out.print("B");
                        state++;
                    }
                    lock.unlock();//release lock
                }
            }
        });

        Thread C=new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (state<=30) {
                    lock.lock();//get lock
                    if (state%3==2) {
                        System.out.print("C");
                        state++;
                    }
                    lock.unlock();//release lock
                }
            }
        });

        A.start();
        B.start();
        C.start();

    }


}


