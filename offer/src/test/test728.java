package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer>ans=new ArrayList<>();
        for (int i = left; i <=right; i++) {
            if(check(i))
                ans.add(i);
        }
        return ans;
    }
    boolean check(int number)
    {
        int copy=number;
        while (copy!=0)
        {
            int temp=copy%10;
            if(number%temp!=0)
                return false;
            copy=copy/10;
        }
        return true;
    }

    @Test
    public void test()
    {
        System.out.println(check(22));
    }
}
