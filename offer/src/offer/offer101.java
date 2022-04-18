package offer;

public class offer101 {
    public boolean canPartition(int[] nums) {
    int len=nums.length;
    int sum=0;
    for(int num:nums)
       sum+=num;
    if((sum&1)==1)//如果sum不是偶数，则直接返回false
        return false;
    int target=sum/2;
    boolean[][]dp=new boolean[len][target+1];//将0考虑在内了
    if(nums[0]<=target)
        dp[0][nums[0]]=true;
    for(int i=0;i<len;i++)
    {
        for (int j=0;j<=target;j++)
        {
            dp[i][j]=dp[i-1][j];//不考虑当前的数字
            if(nums[i]==j)
            {
                dp[i][j]=true;
                continue;
            }
            if(nums[i]<j)
              dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];

        }
    }
    return dp[len-1][target];
    }
}
