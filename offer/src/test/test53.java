package test;

import org.junit.Test;

public class test53 {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
    for(int i=0;i<nums.length;i++){
         sum=sum+nums[i];
         if(sum<nums[i]){
             sum=nums[i];
         }
         max=Math.max(sum,max);
    }
    return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
