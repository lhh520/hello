package 代码随想录二刷.回溯;

public class 最大字数组的和 {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int preSum=nums[0];
        for(int i=1;i< nums.length;i++){
            preSum+=nums[i];
            if(preSum<nums[i]){
                preSum=nums[i];
            }
            max=Math.max(max,preSum);
        }
        return max;
    }
    public int maxSubArray1(int[]nums){
        int ans=Integer.MIN_VALUE;
        int[]dp=new int[nums.length];//其中dp[i]就是以i结尾的最小值
        dp[0]=nums[0];
        ans=dp[0];
        for(int i=0;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);//表示dp[i]以i结尾的最小值
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
