import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test414 {
    public int thirdMax(int[] nums) {
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        int k=3;
        int i;
        for(i=nums.length-1;i>0;i--)
        {
            if(nums[i]==nums[i-1])
                continue;
            k--;
            if(k==0)
                break;
        }
        if(i<0)
            return nums[nums.length-1];
        else
        return nums[i];
    }
    @Test
    public void test()
    {
        //[2, 2, 3, 1]
        //[3, 2, 1]
        int[] nums=new int[]{2, 1};
        System.out.println(thirdMax(nums));
    }
}
