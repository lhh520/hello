package test;

public class test1277 {
    public int countSquares(int[][] matrix) {
        int sum=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return sum;
        }

        //获取到行和列的数量
        int rows=matrix.length,cols=matrix[0].length;
        int[][]dp=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0||j==0)
                    dp[i][j]=matrix[i][j];
                else if(matrix[i][j]==0)
                    dp[i][j]=0;
                else
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                sum=sum+dp[i][j];
            }
        }
        return sum;
    }
}
