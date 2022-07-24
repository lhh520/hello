package testproject;

public class 矩阵区域和 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length,n=mat[0].length;
        int[][]dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+mat[i-1][j-1]-dp[i-1][j-1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int x1=i-k,y1=j-k,x2=i+k,y2=j+k;
                if(x1<1) x1=1;
                if(y1<1) y1=1;
                if(x2>n) x2=n;
                if(y2>m) y2=m;
                mat[i-1][j-1]=dp[x2][y2]+dp[x1-1][y1-1]-dp[x1-1][y2]-dp[x2][y1-1];
            }
        }
        return mat;
    }
}
