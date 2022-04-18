import org.junit.Test;

public class face16_17 {
    public int maxSubArray(int[] nums) {
        int length=nums.length;
        int[]dp=new int[length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int max=Integer.MIN_VALUE;
        //return dp[length-1];
        for(int i=1;i<dp.length;i++)
        {
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    @Test
    public void test()
    {
        int[]nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
