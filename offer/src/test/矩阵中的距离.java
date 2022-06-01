package test;

import org.junit.Test;

import java.util.Arrays;

public class 矩阵中的距离 {
    int[][]dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][]ans=new int[m][n];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                }else {
                    ans[i][j]=dfs(mat,i,j);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][]mat,int i,int j){
        if(i<0||i>=mat.length||j<0||j>=mat[0].length||mat[i][j]==2){
            return 1000;
        }
        if(mat[i][j]==0){
            return 0;
        }
        int min=1000;
        int temp=mat[i][j];
        mat[i][j]=2;
        for(int k=0;k<dirs.length;k++){
            int dx=dirs[k][0];
            int dy=dirs[k][1];
            min=Math.min(min,dfs(mat,i+dx,j+dy)+1);
        }
        mat[i][j]=temp;
        return min;
    }
    @Test
    public void test(){
        int[][]mat=new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][]ans=updateMatrix(mat);
        for(int[]nn:ans){
            System.out.println(Arrays.toString(nn));
        }
    }
}
