package dp;

import org.junit.Test;

public class test509 {
    public int fib(int n) {
        if(n==0)
            return 0;
       if(n==1)
           return 1;
       return fib(n-2)+fib(n-1);
    }
    @Test
    public void test(){
        System.out.println(fib(4));
    }
}
