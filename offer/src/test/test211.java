package test;

import java.util.Arrays;

public class test211 {
    public double[] dicesProbability(int n) {
        double[]dp=new double[n];
    Arrays.fill(dp,1.0/6.0);
    for(int i=2;i<=n;i++){
        double[]temp=new double[5*1+1];
        for(int j=0;j<dp.length;j++){
            for(int k=0;k<6;k++){
                temp[j+k]+=dp[j]/6.0;
            }
        }
        dp=temp;
    }
    return dp;
    }
    public int maximalSquare(char[][] matrix) {
    int maxSide=0;
    if(matrix==null||matrix.length==0||matrix[0].length==0){
        return maxSide;
    }

    //获取到行和列的数量
    int rows=matrix.length,cols=matrix[0].length;
    int[][]dp=new int[rows][cols];
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(matrix[i][j]=='1'){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
                maxSide=Math.max(maxSide,dp[i][j]);
            }
        }
    }
    int max=maxSide*maxSide;
    return max;
    }
}
