package LCP;

import java.util.Arrays;

public class test416 {
    public boolean canPartition(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        int[]dp=new int[target+1];
        //0 1 背包问题
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j-nums[i]]+nums[i],dp[j]);
            }
        }
        return dp[target]==target;
    }
}
