package testproject;

import org.junit.Test;

public class 最小路径之和 {
//    int res=Integer.MAX_VALUE;
//    int m,n;
//    int cur=0;
//    int[][]dirs=new int[][]{{1,0},{0,1}};
//    public int minPathSum(int[][] grid) {
//        m=grid.length;
//        n=grid[0].length;
//        cur=grid[0][0];
//        backtrace(grid,0,0);
//        return res;
//    }
//    public void backtrace(int[][]grid,int i,int j){
//        if(i==m-1&&j==n-1){
//            res=Math.min(res,cur);
//            return;
//        }
//        for(int k=0;k<dirs.length;k++){
//            int ii=i+dirs[k][0];
//            int jj=j+dirs[k][1];
//            if(ii>=0&&ii<m&&jj>=0&&jj<n){
//                cur=cur+grid[ii][jj];
//                backtrace(grid,ii,jj);
//                cur=cur-grid[ii][jj];
//            }
//        }
//    }
    public int minPathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp=new int[m][n];
        //初始化
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];

    }
    @Test
    public void test(){
        int[][]grid=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

}
