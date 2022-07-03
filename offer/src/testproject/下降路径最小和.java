package testproject;

import org.junit.Test;

public class 下降路径最小和 {

    public int minFallingPathSum(int[][] matrix) {
        int max=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            int min=dfs(0,i,matrix);
            max=Math.min(min,max);
        }
        return max;
    }
    public int dfs(int i,int j,int[][] matrix){
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        int sum1=Integer.MAX_VALUE;
        int sum2=Integer.MAX_VALUE;
        int sum3=Integer.MAX_VALUE;
        if(j>0&&j<matrix[0].length&&i>=0&&i<matrix.length-1)
        sum1=matrix[i][j]+dfs(i+1,j-1,matrix);
        if(j>=0&&j<matrix[0].length&&i>=0&&i<matrix.length-1){
            sum2=matrix[i][j]+dfs(i+1,j,matrix);
        }
        if(j>=0&&j<matrix[0].length-1&&i>=0&&i<matrix.length-1){
            sum3=matrix[i][j]+dfs(i+1,j+1,matrix);
        }
        return Math.min(sum1,Math.min(sum2,sum3));
    }
    public int minFallingPathSum1(int[][] matrix){
        int N=matrix.length;
        for(int r=N-2;r>=0;r--){
            for(int c=0;c<N;c++){
                int b=matrix[r+1][c];
                if(c>0){
                    b=Math.min(b,matrix[r+1][c-1]);
                }
                if(c+1<N){
                    b=Math.min(b,matrix[r+1][c+1]);
                }
                matrix[r][c]+=b;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int x:matrix[0]){
            ans=Math.min(ans,x);
        }
        return ans;
    }
    @Test
    public void test(){
        int[][]matrix =new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum1(matrix));
    }
}
