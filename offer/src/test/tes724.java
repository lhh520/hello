package test;

import org.junit.Test;

public class tes724 {
    public int pivotIndex(int[] nums) {
    int sum=0;
        for (int i = 0; i <nums.length; i++) {
            sum=sum+nums[i];
        }
        //int target=sum/2;
        int sum2=0;
        for (int i = 1; i <nums.length; i++) {
            int target=sum-nums[i];
            sum2=sum2+nums[i-1];
            if(sum2==target/2)
                return i;
        }
        return -1;
    }
    @Test
    public void test()
    {
        int[]nums =new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
