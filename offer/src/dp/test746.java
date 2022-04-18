package dp;

import org.junit.Test;

import java.util.Arrays;

public class test746 {
    public int minCostClimbingStairs(int[] cost) {
    int n=cost.length;
    if(n==0){
        return cost[0];
    }
    if(n==1){
        return Math.min(cost[0],cost[1]);
    }
    int[]dp=new int[n];
    dp[0]=cost[0];
    dp[1]=cost[1];
    //dp[2]=Math.min(dp[0]+cost[2],dp[1]+cost[2])
    for(int i=2;i<n;i++){
        dp[i]=Math.min(dp[i-2],dp[i-1])+cost[i];
    }
        //System.out.println(Arrays.toString(dp));
    return Math.min(dp[n-1],dp[n-2]);
    }
    @Test
    public void test(){
        int[] cost=new int[]{10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
