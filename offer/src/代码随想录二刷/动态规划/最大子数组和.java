package 代码随想录二刷.动态规划;

import org.junit.Test;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
         int Presum=nums[0];
         int max=Presum;
         for(int i=1;i< nums.length;i++){
             Presum+=nums[i];
             if(Presum<nums[i]){
                 Presum=nums[i];
             }
             max=Math.max(max,Presum);
         }
         return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
