package test;

import java.util.Arrays;

public class 网格中的最小路径代价 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n=grid.length,m=grid[0].length;
        int[][]dp=new int[n][m];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int j=0;j<m;j++){
            dp[0][j]=grid[0][j];//每个人到自己的代价都为本身的距离
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j]=Math.min(dp[i-1][k]+moveCost[grid[i-1][k]][j]+grid[i][j],dp[i][j]);
                }
            }
        }
        n--;
        for(int j=0;j<m;j++){
            ans=Math.min(ans,dp[n][j]);
        }
        return ans;
    }
}
