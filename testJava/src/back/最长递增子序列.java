package back;

import java.util.Arrays;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
