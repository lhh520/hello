package testproject;

import org.junit.Test;

public class 矩阵中的最长递增路径 {
    private int[][]dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows,columns;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        rows=matrix.length;
        columns=matrix[0].length;
        int[][]memo=new int[rows][columns];
        int ans=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                ans=Math.max(ans,dfs(matrix,i,j,memo));
            }
        }
        return ans;
    }
    public int dfs(int[][]matrix,int i,int j,int[][]memo){
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        memo[i][j]++;
        for(int[]dir:dirs){
            int newRow=i+dir[0],newCol=j+dir[1];
            if(newRow>=0&&newRow<rows&&newCol>=0&&newCol<columns&&matrix[newRow][newCol] > matrix[i][j]){
                memo[i][j]=Math.max(memo[i][j],dfs(matrix,newRow,newCol,memo)+1);
            }
        }
        return memo[i][j];
    }
}
