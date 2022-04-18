public class test695
{
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        //对每个格子进行遍历
    for(int i=0;i<grid.length;i++)
    {
        for(int j=0;j<grid[0].length;j++)
        {   //当遇到陆地的时候，就进行左右上下的扫描
            if(grid[i][j]==1)
                res=Math.max(MaxArea(grid,i,j),res);
        }
    }
    return  res;
    }
    public int MaxArea(int[][]grid,int i,int j)
    {   //判定当前节点是否还在格子里面，是否还符合条件
        if(!InArea(grid,i,j))
            return 0;
        //如果格子搜索过了，或者是0，就要返回面积等于0
        if(grid[i][j]!=1)
            return 0;
        //访问过的就标记为2
        grid[i][j]=2;
        //计算当前的节点的左右上下节点，进行搜索
        return 1+MaxArea(grid,i-1,j)+MaxArea(grid,i+1,j)+MaxArea(grid,i,j-1)+MaxArea(grid,i,j+1);
    }
    //判定数字是否在格子上
    public Boolean InArea(int[][]grid,int i,int j)
    {
        return (i>=0&&i<grid.length&&j>=0&&j<grid[0].length);
    }

}
