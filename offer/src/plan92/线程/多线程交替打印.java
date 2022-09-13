package plan92.线程;

import org.junit.Test;

public class 多线程交替打印 {
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
    class T1 implements Runnable{
         @Override
         public void run(){
              for(int i=0;i<10;i++){
                   while (count%3!=1){

                   }
                   synchronized(count){
                       if(count%3==1){
                           System.out.println("A");
                           count++;
                           i++;
                       }
                  }
              }
        }
    }
    class T2 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                while (count%3!=2){

                }
                synchronized(count){
                    if(count%3==2){
                        System.out.println("B");
                        count++;
                        i++;
                    }
                }
            }
        }
    }
    class T3 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                while (count%3!=0){

                }
                synchronized(count){
                    if(count%3==0){
                        System.out.println("C");
                        count++;
                        i++;
                    }
                }
            }
        }
    }
}
