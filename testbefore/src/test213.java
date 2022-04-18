public class test213
{
    public int rob(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len+1];
        dp[0]=nums[0];
        for(int i=1;i<len;i++)
        {
            dp[i]=Math.max(dp[i-1]+nums[i-1],dp[i-1]);
        }
        return dp[len];
    }
}
