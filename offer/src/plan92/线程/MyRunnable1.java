package plan92.线程;

public class MyRunnable1 implements Runnable{
    Dress dress;
    Trousers trousers;

    public MyRunnable1() {
    }

    public MyRunnable1(Dress dress, Trousers trousers) {
        this.dress = dress;
        this.trousers = trousers;
    }

    @Override
    public void run() {
        synchronized(dress){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (trousers){
                System.out.println("--------------");
            }
        }
    }
}

class MyRunnable2 implements Runnable{
    Dress dress;
    Trousers trousers;

    public MyRunnable2() {
    }

    public MyRunnable2(Dress dress, Trousers trousers) {
        this.dress = dress;
        this.trousers = trousers;
    }

    @Override
    public void run() {
        synchronized(trousers){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (dress){
                System.out.println("。。。。。。。。。。。。。。");
            }
        }
    }

}
class Dress{

}

class Trousers{

}