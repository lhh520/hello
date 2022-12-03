package dp;

public class two {
    //synchronized  int b=0;
    static  int a=0;
    volatile  static int b=0;
    static int[]bb=new int[]{1,2,3,4,5,6,7,8,9};
    static Object o=new Object();
    static class Thread1 implements Runnable {

        @Override
        public void run() {
            while (true)
            if(b%2==0){
                System.out.println(bb[b]);
                b++;
            }

        }
    }
    static class Thread2 implements Runnable {

        @Override
        public void run() {
            while (true)
            if(b%2==1){
                System.out.println(bb[b]);
                b++;
            }

        }
    }

    public static void main(String[] args) {
        Thread1 t1=new Thread1();
        Thread2 t2=new Thread2();
        t1.run();
        t2.run();
    }

}
