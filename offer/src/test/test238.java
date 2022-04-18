package test;

import org.junit.Test;

import java.util.Arrays;

public class test238 {
    public int[] productExceptSelf(int[] nums) {
    int sum=1;
    int flag=0;
    for(int num:nums)
    {   if(num==0)
    {   flag++;
        continue;
    }
        sum=sum*num;
    }
    int[]ans=new int[nums.length];
    if(flag>=2)
    {
        return ans;
    }
    if(flag==1)
    {   int bb=0;
        for (int i = 0; i < nums.length; i++) {
            {   if(nums[i]==0)
                 bb=i;
                break;
            }
        }
        ans[bb]=sum;
        return ans;
    }
    for(int i=0;i<ans.length;i++)
    {
        ans[i]=sum/nums[i];
    }
    return ans;
    }
    @Test
    public void test()
    {
        int[]nn=new int[]{1,2,3,4};
        int[] nnm=productExceptSelf(nn);
        System.out.println(Arrays.toString(nnm));
    }
}
