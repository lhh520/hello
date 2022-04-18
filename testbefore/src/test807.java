import org.junit.Test;

import java.util.Arrays;

public class test807
{
    public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] row=new int[grid.length];
    //求的每一行的最大值
    int[] col=new int[grid[0].length];
    for(int i=0;i<row.length;i++)
    {
        row[i]=max_r(grid[i]);
        //System.out.println("roe:  "+row[i]);
    }
    //求的每一列的最大值
    for(int j=0;j<col.length;j++)
    {   int temp=Integer.MIN_VALUE;
        for(int i=0;i<row.length;i++)
        {
            if(temp<grid[i][j])
                temp=grid[i][j];
        }
        col[j]=temp;
        //System.out.println("col:  "+temp);
    }
    int sum=0;
    for(int i=0;i<grid.length;i++)
    {
        for(int j=0;j<grid[0].length;j++)
        {
            sum=sum+Math.min(row[i],col[j])-grid[i][j];
        }
    }
    return sum;
    }
    public int max_r(int[] grid)
    {   int ans=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i]>ans)
                ans=grid[i];
        }
        return ans;
    }
    @Test
    public void test()
    {
        int[][] grid=new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }
}
