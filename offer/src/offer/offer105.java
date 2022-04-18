package offer;

public class offer105
{   int res=0;
    public int maxAreaOfIsland(int[][] grid) {

     for(int i=0;i<grid.length;i++)
     {
         for(int j=0;j<grid[0].length;j++)
         {   //如果当前值满足条件，是岛屿，进行遍历
             if(grid[i][j]==1)
                 //res是当前的连通区域内的岛屿数，然后与记录的最大值进行比较
                 res=Math.max(MaxArea(grid,i,j),res);
         }
     }
     return res;
    }
    //计算最大值
    public int MaxArea(int[][] grid, int i, int j)
    {   //如果遍历已经出去了整个二维数组，越界，应当返回
        if(!InArea(grid,i,j))
            return 0;
        //不等于1，两种情况，第一是当前不是岛屿，另一种是已经遍历过
        if(grid[i][j]!=1)
            return 0;
        //遍历过变成2，防止重复遍历
        grid[i][j]=2;
        //1+向四个方向进行的遍历
        return 1+MaxArea(grid,i-1,j)+MaxArea(grid,i+1,j)+MaxArea(grid,i,j+1)+MaxArea(grid,i,j-1);
    }
    //判定是否越界
    boolean InArea(int[][] grid, int i, int j)
    {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)
            return false;
        return true;
    }
}
