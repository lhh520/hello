package test;

import org.junit.Test;

public class test397 {
    public int integerReplacement(int n)
    {
       if(n==1)
           return 0;
       if(n%2==0)
           return 1+integerReplacement(n/2);
       return 2+Math.min(integerReplacement(n/2),integerReplacement(n/2+1));
    }
    @Test
    public void test()
    {
        int ss=integerReplacement(8);
        System.out.println(ss);
    }
}
