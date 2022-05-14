package testproject;

import org.junit.Test;

public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int maxSide=0;
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    if(i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }
                    maxSide=Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }


}
