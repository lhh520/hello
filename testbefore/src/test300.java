import org.junit.Test;

public class test300 {
    public int lengthOfLIS(int[] nums) {
        //定义动态规划数组
    int[]dp=new int[nums.length];
    //初始化数组
    for(int i=0;i<dp.length;i++)
        dp[i]=1;
    for(int i=1;i<nums.length;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(nums[i]>nums[j])
                dp[i]=Math.max(dp[i],dp[j]+1);//计算从0-i-1，计算当前值小的数字
        }
    }
    int max=1;
    for(int i=0;i<dp.length;i++)
    {
        max=Math.max(max,dp[i]);
    }
    return max;
    }
    @Test
    public void test()
    {
        int[] nu=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS1(nu));
    }
    //
    public int lengthOfLIS1(int[] nums)
    {
        int[]dp=new int[nums.length];
        //动态数组的初始化
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=1;
        }
        //状态转移方程dp[i]=max(dp[i],dp[j]+1)
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        //挑选状态
        int max=0;
        for(int i=0;i<dp.length;i++)
        {
            max=Math.max(max,dp[i]);
        }
        return max;
    }

}
