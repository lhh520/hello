package test;

import org.junit.Test;

public class test766 {
    public boolean isToeplitzMatrix1(int[][] matrix)
    {
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i = 1; i <m; i++) {
            for (int j = 1; j <n; j++) {
                if(matrix[i][j]!=matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i = 0; i <n; i++) {
            int temp=matrix[0][i];
        for(int j=0;j<Math.min(m,n-i);j++)
        {  if(j+1<=m-1&&i+1<=n-1)
        {int c=matrix[j+1][i+1];
            if(c!=temp)
                return false;
        }
        }
        }
        return true;
    }
    @Test
    public void test()
    {
       //[[36,59,71,15,26,82,87],[56,36,59,71,15,26,82],[15,0,36,59,71,15,26]]
    }
}
