package 热题100;

import org.junit.Test;

public class 岛屿数量 {
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
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
            int ii=i+dirs[k][0];
            int jj=j+dirs[k][1];
            //if(ii>=0&&ii<grid.length&&jj>=0&&jj<grid[0].length)
            dfs(grid,ii,jj);
        }
    }
    @Test
    public void test(){
        char[][]chars=new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(numIslands(chars));
    }


}
