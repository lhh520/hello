package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer>setx=new HashSet<>();
        Set<Integer>sety=new HashSet<>();
        int m=matrix.length,n=matrix[0].length;
        //找到0
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++)
            {
                 if(matrix[i][j]==0)
                 {
                     setx.add(i);
                     sety.add(j);
                 }
            }
        }
        //
        for (int i = 0; i <m; i++)
        {
            for (int j = 0; j <n; j++)
            {
                if(setx.contains(i)||sety.contains(j))
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}
