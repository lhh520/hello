

public class test463
{   static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    public int islandPerimeter(int[][] grid) {
        int n=grid.length,m=grid[0].length;//得到格子的长和宽
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int cnt=0;
                    for(int k=0;k<4;k++)//模拟上下左右四个方向
                    {
                        int tx=i+dx[k];//当k=0时，i不变，j+1，表示上一个单位
                        int ty=j+dy[k];
                        //tx<0||tx>=n||ty<0||ty>=m:表示为边界
                        //grid[tx][ty]==0：表示当前陆地的邻为水域，当前应当记为陆地大小
                        if(tx<0||tx>=n||ty<0||ty>=m||grid[tx][ty]==0)
                            cnt+=1;
                    }
                    ans+=cnt;

                }

            }
        }
        return ans;
    }
    public int island(int[][] grid)
    {
        int n=grid.length,m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                 ans=ans+dfs(i,j,grid,n,m);
            }
        }
        return ans;
    }
    public int dfs(int i,int j,int[][]grid,int n,int m)
    {
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0)
            return 1;
        if(grid[i][j]==2)
            return 0;
        int res=0;
        for(int k=0;k<4;k++)
        {
            int tx=i+dx[k];
            int ty=j+dy[k];
            res=res+dfs(tx,ty,grid,n,m);
        }
        return res;
    }
}
