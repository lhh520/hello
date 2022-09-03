package plan92.线程;

public class test1 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();
        for(int i=0;i<1000;i++){
            System.out.println("主线程"+i);
        }
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            Thread thread=Thread.currentThread();
            System.out.println(thread.getName()+"分支线程--->" + i);
        }
    }
}
class Mythread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("分支线程"+i);
        }
    }
}
