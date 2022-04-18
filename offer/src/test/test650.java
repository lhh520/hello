package test;

import org.junit.Test;

public class test650 {
    public int minSteps(int n) {
       int[] f=new int[n+1];
       for(int i=2;i<=n;i++)
       {
           f[i]=Integer.MAX_VALUE;
           for(int j=i+1;j*j<i;j++)
           {
               if(i%j==0)
               {
                   f[i]=Math.min(f[i],f[j]+i/j);//表示的是将刚好能整除的数进行整除
                   f[i]=Math.min(f[i],f[i/j]+j);
               }
           }
       }
       return f[n];
    }
    @Test
    public void test()
    {
        System.out.println(minSteps(32));
    }
}
