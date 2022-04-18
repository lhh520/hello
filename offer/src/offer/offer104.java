package offer;

public class offer104 {
    public int combinationSum4(int[] nums, int target)
    {
        //定义动态数组
    int[] dp=new int[target+1];
    //初始化变量
    dp[0]=1;
    //从1到当前值，所有的组合情况
    for(int i=1;i<=target;i++)
    {   //对可以有的选择进行遍历
        for(int num:nums)
        {
            if(num<=i)
                dp[i]=dp[i]+dp[i-num];
        }
    }
    return dp[target];
    }
}
