package plan92.线程;

public class 多线程3 {
    private static Object resource1=new Object();
    private static Object resource2=new Object();

    public static void main(String[] args) {
       new Thread(()->{
          synchronized (resource1){
              try {
                  Thread.sleep(10000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              synchronized (resource2){
                  System.out.println("get2");
              }
          }
       }).start();
        new Thread(()->{
            synchronized (resource2){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1){
                    System.out.println("get1");
                }
            }
        }).start();
    }

}
