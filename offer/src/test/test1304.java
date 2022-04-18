package test;

import org.junit.Test;

import java.util.Arrays;

public class test1304 {
    public int[] sumZero(int n) {
        int[]nums=new int[n];
        //if(n%2==0)
        {
            for (int i = 0; i <n/2; i++)
            {
                nums[i]=-(i+1);
            }
            for (int i = n/2; i <n; i++)
            {
                nums[i]=(i+1)-n/2;
            }

        }
        if(n%2!=0)
            nums[n-1]=0;
        System.out.println(Arrays.toString(nums));
        return nums;
    }
    @Test
    public void test()
    {
        sumZero(3);
    }
}
