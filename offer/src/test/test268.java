package test;

import org.junit.Test;

import java.util.Arrays;

public class test268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]!=nums[i]+1)
                return nums[i]+1;
        }
        return -1;
    }
    @Test
    public void test()
    {
        int[] nn=new int[]{3,0,1};
        System.out.println(missingNumber(nn));
    }
}
