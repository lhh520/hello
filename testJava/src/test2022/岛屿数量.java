package test2022;

public class 岛屿数量 {

    int[][]dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid){
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]=='1')
                {
                    num++;
                    dfs(grid,i,j);
                }

            }
        }
        return num;
    }
    public void dfs(char[][]grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for(int k=0;k<4;k++){
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            dfs(grid,nx,ny);
        }
    }
}
