package 代码随想录二刷.动态规划;

import java.util.Arrays;

public class 分割等和子集 {
    public boolean canPartition(int[] nums){
        int sum= Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }

        int bagsize=sum%2;
        int[]dp=new int[bagsize+1];
        for(int i=0;i<nums.length;i++){//每个只能用一次
            for(int j=bagsize;j>=nums[i];j--){
                dp[j]=Math.max(dp[j-nums[i]]+nums[i],dp[j]);
            }
        }
        return dp[bagsize]==bagsize;
    }
}
