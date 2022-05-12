package test;

import org.junit.Test;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            max=Math.max(sum,max);
            if(sum<=0){
                sum=0;
            }


        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,1};
        System.out.println(maxSubArray(nums));
    }
}
