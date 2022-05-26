package 代码随想录;

import org.junit.Test;

public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[]dp=new int[n];
        dp[0]=cost[0];
        dp[1]=Math.min(cost[0],cost[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        //return dp[n-1];
        return Math.min(dp[n-1],dp[n-2]);
    }
    @Test
    public void test(){
        int[]cost=new int[]{10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
