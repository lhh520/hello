package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test1414 {
    public int findMinFibonacciNumbers(int k) {
    int a=1,b=1;
    List<Integer> list=new ArrayList<>();
    list.add(a);
    list.add(b);
    while (b<k)
    {
       int c=a;
       a=b;
       b=c+a;
       list.add(b);
    }
    int ans=0;
    for(int i=list.size()-1;i>=0&&k>0;i--)
    {
        int num=list.get(i);
        if(k>=num)
        {
            k-=num;
            ans++;
        }
    }
    return ans;
    }
    @Test
    public void test()
    {
        int k=10;
        System.out.println(findMinFibonacciNumbers(k));
    }
}
