package testproject;

import org.junit.Test;

public class 最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        int res=0;
        int n=nums.length;
        int maxLen=0;
        int ans=0;
        int[]dp=new int[n];
        int[]cnt=new int[n];
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }

        }

       return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
}
