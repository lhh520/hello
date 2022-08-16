package 代码随想录二刷.动态规划;

public class 打家劫舍2 {
    public int rob(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int r1=getcicle(nums,1,nums.length-1);
        int r2=getcicle(nums,0,nums.length-2);
        return Math.max(r1,r2);
    }
    public int getcicle(int[]nums,int start,int end){
        if(start==end){
            return nums[start];
        }
        int[]dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(dp[start],dp[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
