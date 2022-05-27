package 代码随想录;

import org.junit.Test;

public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum=sum+num;
        }
        if(sum%2!=0){
            return false;
        }
        int bagsize=sum/2;
        int[]dp=new int[bagsize+1];

        for(int i=0;i<nums.length;i++){
//            for(int j=bagsize;j>=nums[i];j--){
//                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
//            }
            for(int j=nums[i];j<=bagsize;j++){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[bagsize]==bagsize;

    }
    @Test
    public void test(){
        int[]nums=new int[]{1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
