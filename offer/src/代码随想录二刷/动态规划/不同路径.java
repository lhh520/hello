package 代码随想录二刷.动态规划;

public class 不同路径 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][]dp=new int[m][n];
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1){
                break;
            }
            dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            dp[i][0]=1;
        }
        return 0;
    }
}
