package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorDemo
{
    private static final int CORE_POOL_SIZE=5;//核心线程数
    private static final int MAX_POOL_SIZE=10;//最大线程数
    private static final int QUEUE_CAPACITY=100;//容量为100
    private static final Long KEEP_ALIVE_TIME=1L;
    public static void main(String[] args) {
        //线程池的创建
        ThreadPoolExecutor excutor=new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),new ThreadPoolExecutor.CallerRunsPolicy()//饱和策略
        );
        for(int i=0;i<10;i++)
        {   //创建WorkerThread对象
            Runnable worker=new MyRunnable(""+i);
            //执行Runnable
            excutor.execute(worker);
        }
        excutor.shutdown();
        while (!excutor.isTerminated())
            System.out.println("Finished all threads");

    }

}
