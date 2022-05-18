package testproject;

import org.junit.Test;

public class 黄金矿工 {
    int[][]dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int[][]grid;
    int ans;
    public int getMaximumGold(int[][] grid) {
        this.grid=grid;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    dfs(i,j,0);
                }
            }
        }
        return ans;
    }
    public void dfs(int i,int j,int gold){
        gold+=grid[i][j];
        ans=Math.max(ans,gold);
        int recv=grid[i][j];
        grid[i][j]=0;
        for(int k=0;k<4;k++){
            int ii=i+dirs[k][0];
            int jj=j+dirs[k][1];
            if(ii>=0&&ii<grid.length&&jj>=0&&jj<grid[0].length&&grid[ii][jj]>0){
                dfs(ii,jj,gold);
            }
        }
        grid[i][j]=recv;
    }
    @Test
    public void test(){
        int[][]grid=new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(grid));
    }
}
