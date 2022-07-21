package 代码随想录二刷.数组;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>list=new ArrayList<>();
        int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m=matrix.length,n=matrix[0].length;
        int sum=m*n,cur=1,i=0,j=0,k=0;
        boolean[][]flag=new boolean[m][n];
        while(cur<=sum){
            list.add(matrix[i][j]);
            flag[i][j]=true;
            cur++;
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            if(nx<0||ny<0||nx>=n||ny>=n||flag[nx][ny]){
                k=(k+1)%4;
            }
            i=i+dirs[k][0];
            j=j+dirs[k][1];
        }
        return list;
    }
}
