package testproject;

import org.junit.Test;

public class 粉刷房子 {
    public int minCost(int[][] costs) {
        int n=costs.length;
        int[][]dp=new int[n][3];//表示分别涂成三个演的的花费
        for(int i=0;i<3;i++){
            dp[0][i]=costs[0][i];
        }
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2]=Math.max(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][1]));
    }
    @Test
    public void test(){

    }
}
