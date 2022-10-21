package plan92;

import org.junit.Test;
import plan92.线程.多线程交替打印;

public class test77 {
    private volatile Integer count=1;
    @Test
    public void test(){
        Thread t1=new Thread(new T1());
        Thread t2=new Thread(new T2());
        Thread t3=new Thread(new T3());
        t1.start();
        t2.start();
        t3.start();
    }
    //线程1
    class T1 implements Runnable{
        @Override
        public void run(){
            for(int i=1;i<10;i++){
                while (count%3!=1){

                }
                synchronized (count){
                    System.out.println("A");
                    count++;
                    i++;
                }
            }
        }
    }
    //线程2
    class T2 implements Runnable{
        @Override
        public void run(){
            for(int i=1;i<10;i++){
                while (count%3!=2){

                }
                synchronized (count){
                    System.out.println("B");
                    count++;
                    i++;
                }
            }
        }
    }
    //
    class T3 implements Runnable{
        @Override
        public void run(){
            for(int i=1;i<10;i++){
                while (count%3!=0){
                }
                synchronized (count){
                    System.out.println("C");
                    count++;
                    i++;
                }
            }
        }
    }
}
