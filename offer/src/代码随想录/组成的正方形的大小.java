package 代码随想录;

public class 组成的正方形的大小 {
    public int maximalSquare(char[][] matrix){
        int height=matrix.length;
        int width=matrix[0].length;
        int[][]dp=new int[height+1][width+1];
        int maxSide=0;
        for(int i=1;i<=height;i++){
            for(int j=1;j<=width;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    maxSide=Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
}
