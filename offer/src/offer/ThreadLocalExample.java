package offer;

public class ThreadLocalExample
{
    private static ThreadLocal<String>local=new ThreadLocal<String>();
    static void print(String str)
    {   //打印当前线程中本地内存中本地变量的值
        System.out.println(str+" : "+local.get());
        //清除本地内存中的本地变量
        local.remove();
    }

    public static void main(String[] args) throws InterruptedException
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalExample.local.set("local_A");
                print("A");
                System.out.println("af remove:"+local.get());
            }
        },"A").start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalExample.local.set("local_B");
                print("B");
                System.out.println("af remove:"+local.get());
            }
        },"B").start();
        Thread.sleep(1000);

    }


}
