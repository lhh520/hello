package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class offer41
{   List<Integer>list=new ArrayList<>();
    public int maxValue(int[][] grid) {
    int m=grid.length,n=grid[0].length;
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(i==0&&j==0)
                continue;
            if(i==0)
                grid[i][j]=grid[i][j]+grid[i][j-1];
            else if(j==0)
                grid[i][j]=grid[i][j]+grid[i-1][j];
            else
                grid[i][j]=Math.max(grid[i][j]+grid[i][j-1],grid[i][j]+grid[i-1][j]);

        }

    }
        return grid[m-1][n-1];
    }

    @Test
    public void test()
    {
       String ans= "[[1,3,1],[1,5,1],[4,2,1]]";
       ans=ans.replaceAll("\\[","\\{");
       ans=ans.replaceAll("\\]","\\}");
        System.out.println(ans);
       int[][]grid=new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int aa=maxValue(grid);
        System.out.println(aa);

    }
}
