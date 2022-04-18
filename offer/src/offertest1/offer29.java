package offertest1;

import org.junit.Test;

import java.util.Arrays;

public class offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        if(matrix==null||m==0||m==0){
            return new int[]{};
        }
        //表示四个方向
        int[][]directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[] ans=new int[m*n];
        //记录
        boolean[][]flag=new boolean[m][n];
        int index=0;
        int row=0,col=0;
        for(int i=0;i<m*n;i++){
            ans[i]=matrix[row][col];
            flag[row][col]=true;
            int newRow=row+directions[index][0],newCol=col+directions[index][1];
            if(newRow<0||newRow>=m||newCol<0||newCol>=n||flag[newRow][newCol]){
                index=(index+1)%4;
            }
            row=row+directions[index][0];
            col=col+directions[index][1];
        }
        return ans;
    }
    @Test
    public void test(){
        int[][]matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[]ans=spiralOrder(matrix);
        System.out.println(Arrays.toString(ans));
    }
}
