package testproject;

public class 统计封闭岛屿的数目 {
    int res=0;
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public boolean dfs(int[][]grid,int i,int j){
        int m= grid.length,n= grid[0].length;
        if(i<0||i>=m||j<0||j>=n){
            return false;
        }
        if(grid[i][j]==1){
            return true;
        }
        grid[i][j]=1;
        boolean r1=dfs(grid,i+1,j);
        boolean r2=dfs(grid,i-1,j);
        boolean r3=dfs(grid,i,j+1);
        boolean r4=dfs(grid,i,j-1);
        return r1&&r2&&r3&&r4;
    }

}
