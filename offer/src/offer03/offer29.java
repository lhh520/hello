package offer03;

import org.junit.Test;

import java.util.Arrays;

public class offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        if(matrix==null||m==0||n==0)
            return new int[0];
        int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        int[]nums=new int[m*n];
        boolean[][]flag=new boolean[m][n];
        int index=0;
        int row=0,col=0;
        for(int i=0;i<m*n;i++){
            nums[i]=matrix[row][col];
            flag[row][col]=true;
            int newRow=row+dirs[index][0];
            int newCol=col+dirs[index][1];
            if(newRow<0||newRow>=m||newCol<0||newCol>=n||flag[newRow][newCol]){
                 index=(index+1)%4;
            }
            row=row+dirs[index][0];
            col=col+dirs[index][1];
        }
        return nums;
    }
    @Test
    public void test(){

        int[][]nums=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] ans=spiralOrder(nums);
        System.out.println(Arrays.toString(ans));
    }
}
