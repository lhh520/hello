package test;

import org.junit.Test;

public class test367 {
    public boolean isPerfectSquare(int num) {
       long left=0,right=num;
       while (left<=right)
       {
           long mid=left+(right-left)/2;
           if(mid*mid==num)
               return true;
           else if(mid*mid<num)
               left=mid+1;
           else
               right=mid-1;
       }
       return false;
    }
    @Test
    public void test()
    {
        int num=20;
        System.out.println(isPerfectSquare(20));
    }
}
