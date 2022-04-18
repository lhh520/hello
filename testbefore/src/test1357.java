import org.junit.Test;

import java.util.Arrays;

public class test1357 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sum=new int[nums.length];
        //System.out.println("he");
        for(int i=0;i<nums.length;i++)
        {   //int j=0;
            for(int j=0;j<nums.length;j++)
            {   if(i==j)
                continue;
                if(nums[j]<nums[i])
                    sum[i]++;
            }

        }
        return sum;
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{8,1,2,2,3};
        int[] aum=smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(aum));
    }
}
