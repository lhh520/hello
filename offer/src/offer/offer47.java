package offer;

import org.junit.Test;

import java.util.HashMap;

public class offer47 {

    int ans=0;
    public int maxValue(int[][] grid) {
    dfs(grid,0,0,0);
    return ans;
    }
    public void dfs(int[][]grid,int i,int j,int sum){
        if(i==grid.length-1&&j== grid[0].length-1){
            sum=sum+grid[i][j];
            ans=Math.max(ans,sum);
            return;
        }
    if(i==grid.length||j==grid[0].length){
        return;
    }

    sum=sum+grid[i][j];
    dfs(grid,i+1,j,sum);
    dfs(grid,i,j+1,sum);

    }
    public int maxValue1(int[][] grid){
        for(int i=1;i<grid.length;i++){
            grid[i][0]=grid[i][0]+grid[i-1][0];
        }
        for(int j=1;j<grid[0].length;j++){
            grid[0][j]=grid[0][j]+grid[0][j-1];
        }
        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++){
                grid[i][j]=grid[i][j]+Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
    @Test
    public void test(){
        //[1,3,1],
        //  [1,5,1],
        //  [4,2,1]
        int[][]grid=new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(maxValue1(grid));
    }
}
