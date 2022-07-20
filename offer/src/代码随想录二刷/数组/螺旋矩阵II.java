package 代码随想录二刷.数组;

import org.junit.Test;

import java.util.Arrays;

public class 螺旋矩阵II {
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n) {
        int[][]mat=new int[n][n];
        int sum=n*n,cur=1,i=0,j=0,k=0;
        while(cur<=sum){
            mat[i][j]=cur;
            cur++;
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            if(nx<0||ny<0||nx>=n||ny>=n||mat[nx][ny]!=0){
                k=(k+1)%4;
            }
            i=i+dirs[k][0];
            j=j+dirs[k][1];
        }
        return mat;
    }
    @Test
    public void test(){
        int n=3;
        int[][]mat=generateMatrix(n);
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}

