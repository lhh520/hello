package test;

public class test1020 {
    private static int[][]dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][]visited;
    int m,n;
    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];
        //先遍历从第1行和最后一行出发的所有的网格
        for(int i=0;i<n;i++){
            dfs(grid,0,i);
            dfs(grid,m-1,i);
        }
        //遍历第一列和最后一列
        for(int i=1;i<m-1;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1&&visited[i][j]==false)
                    ans++;
            }
        }
        return ans;
    }
    //进行深度遍历，将所有的可达的方格都变成true
    public void dfs(int[][]grid,int row,int col) {
    if(row>=m||row<0||col>=n||col<0||visited[row][col]||grid[row][col] == 0){
        return;
    }
        visited[row][col]=true;
    for(int[]dir:dirs) {
        dfs(grid,row+dir[0],col+dir[1]);
    }
    }

}
