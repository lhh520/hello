package 代码随想录二刷.动态规划;

import org.junit.Test;

public class 打家劫舍 {
    public int rob(int[] nums){
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[]dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        if(n<=2){
            return dp[1];
        }
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
}
