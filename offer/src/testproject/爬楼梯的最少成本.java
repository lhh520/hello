package testproject;

import org.junit.Test;

public class 爬楼梯的最少成本 {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n<=1){
            return cost[0];
        }
        int[]dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-2],dp[i-1])+cost[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    @Test
    public void test(){
        int[]cost=new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
