package plan92.线程;

class myTrd extends Thread {


    public static void main(String[] args) throws InterruptedException {
        MyThread2 t = new MyThread2();
        t.start();
        t.join(); // 当前线程进入阻塞，t线程执行，直到t线程结束。当前线程才可以继续。
        System.out.println(2);
    }
}

class MyThread2 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }
    }
}

