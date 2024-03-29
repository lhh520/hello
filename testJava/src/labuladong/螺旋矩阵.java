package labuladong;

public class 螺旋矩阵 {
    public int[][] generateMatrix(int n) {
       int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
       int[][]mat=new int[n][n];
       int sum=n*n,cur=1,i=0,j=0,k=0;
       while (sum<cur){
           mat[i][j]=cur;
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
}
