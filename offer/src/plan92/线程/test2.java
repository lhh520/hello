package plan92.线程;
import org.junit.Test;

import java.util.*;
public class test2 {

    @Test
    public void test(){
        List<Object>list=new ArrayList<>();
        Producer p1=new Producer(list);
        Consumer c1=new Consumer(list);
        Thread t1=new Thread(p1);
        Thread t2=new Thread(c1);
        t1.setName("生产者线程");
        t2.setName("消费者线程");
        t1.start();
        t2.start();
    }
    //
    class Producer implements Runnable{
        private List list;
        public Producer(List list) {
            this.list = list;
        }
        @Override
        public void run(){
            while (true){
                synchronized (list){
                    if(list.size()>0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object o=new Object();
                    list.add(o);
                    System.out.println(Thread.currentThread().getName() + "--->" + o);
                    list.notifyAll();
                }

            }
        }
    }
    //
    class Consumer implements Runnable{
        private List list;
        public Consumer(List list) {
            this.list = list;
        }
        @Override
        public void run(){
            while (true){
                synchronized (list){
                    if(list.size()<=0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object obj=list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "--->" + obj);
                    list.notifyAll();
                }

            }
        }
    }
}

