package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 岛屿数量 {
    int[][]dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid){
        int num=0;
        List<List<int[]>>lists=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    num++;
                    List<int[]>list=new ArrayList<>();
                    dfs(grid,i,j,list);
                    lists.add(list);
                }
            }
        }
        for(List<int[]>list:lists){
            for(int i=0;i<list.size();i++){
                System.out.print(Arrays.toString(list.get(i)));
                System.out.print("  ");
            }
            System.out.println();
        }
        return num;
    }
    public void dfs(char[][]grid,int i,int j,List<int[]>list){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';//变成水
        list.add(new int[]{i,j});
        for(int k=0;k<4;k++){
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            dfs(grid,nx,ny,list);
        }
    }
    @Test
    public void test(){
        char[][]grid=new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
}
