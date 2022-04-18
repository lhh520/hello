import org.junit.Test;

import java.util.Arrays;

public class test645 {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] count=new int[nums.length+1];
        int i=0;
        int flag1=0,flag2=0;
        for(i=0;i<nums.length;i++)
        {
            count[nums[i]]++;

        }
        for(i=0;i<count.length;i++)
        {
            if(count[i]==2)
                flag1=i;
            if(count[i]==0)
                flag2=i;
        }
        return new int[]{flag1,flag2};
    }
    @Test
    public void test()
    {
        int[] nu=new int[]{1,2,2,4};
        int[] ans=findErrorNums(nu);
        System.out.println(Arrays.toString(ans));
    }
}
