public class MyThread01 {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();
    public static class Mythread implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("hello,Thread");
        }
    }

    public static void main(String[] args) {
        Mythread mythread=new Mythread();
        new Thread(mythread).start();
    }
}
