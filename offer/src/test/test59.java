package test;

import org.junit.Test;

import java.util.Arrays;

public class test59 {
    public int[][] generateMatrix(int n) {
    int[][]res=new int[n][n];
    int left=0,right=n-1,up=0,down=n-1;
    int index=1;
    while (index<=n*n)
    {
        for(int i=left;i<=right;i++)
        {
            res[up][i]=index;
            index++;
        }
        up++;
        for(int i=up;i<=down;i++)
        {
            res[i][right]=index;
            index++;
        }
        right--;
        for(int i=right;i>=left;i--)
        {
            res[down][i]=index;
            index++;
        }
        down--;
        for(int i=down;i>=up;i--)
        {
            res[i][left]=index++;
            index++;
        }
        left++;
    }
    return res;
    }
    @Test
    public void test()
    {
        int[][]res=generateMatrix(3);
        System.out.println(1);
        System.out.println(Arrays.toString(res));
    }
}
