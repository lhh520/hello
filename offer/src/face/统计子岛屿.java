package face;

public class 统计子岛屿 {
    boolean flag = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m=grid2.length;
        int n=grid2[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(grid1,grid2,i,j);
                if(flag) count++;
                flag=true;
            }
        }
        return count;
    }
    public void dfs(int[][] grid1, int[][] grid,int i,int j){
        int m=grid.length,n=grid[0].length;
        if(i<0||j<0||i>=m||j>=n) return;
        if(grid[i][j]==0) return;
        if(grid[i][j]==0) flag=false;
        grid[i][j]=0;
        dfs(grid1,grid,i-1,j);
        dfs(grid1,grid,i+1,j);
        dfs(grid1,grid,i,j-1);
        dfs(grid1,grid,i,j+1);
    }
}
