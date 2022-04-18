import org.junit.Test;

public class test55 {
    /*public boolean canJump(int[] nums) {
       int[]dp=new int[nums.length];
       //1.初始化动态数组
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=i;
        }
        for(int i=;i<nums.length;i++)
        {
            dp[i]=dp[i-1]
        }
    }*/
    public boolean canJump(int[] nums)
    {
        int rightmost=0;//rightmost是用于记录当前所能到达的最远的位置
        for(int i=0;i<nums.length;i++)
        {
            if(i<=rightmost)//如果当前位置在rightmost所在的范围之内，则应该尝试更新能到达的最远的值
            {
                rightmost=Math.max(rightmost,nums[i]+i);
                if(rightmost<nums.length-1)
                    return false;
            }
        }
        return true;
    }
    public boolean canJump1(int[] nums)
    {
        int n=nums.length;
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {  //判定第i个是否可达。
                //判定的方法是，从第j个出发，加上nums[j],可以到达i
                if(dp[j]&&j+nums[j]>=i)

                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
    @Test
    public void test()
    {
        int[]nums = new int[]{3,2,1,0,4};
        System.out.println(canJump1(nums));
    }
}
