package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 迷路的机器人 {
    List<List<Integer>>lists=new ArrayList<>();
    boolean[][]visited;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        visited=new boolean[m][n];
        dfs(obstacleGrid,0,0);
        //System.out.println(visited[0][0]);
        return lists;
    }
    public boolean dfs(int[][]obstacleGrid,int i,int j){
        //越界审查
        if(i>=obstacleGrid.length||j>=obstacleGrid[0].length||obstacleGrid[i][j]==1||visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        lists.add(Arrays.asList(i,j));
        if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1){
            return true;
        }
        if(dfs(obstacleGrid,i+1,j)||dfs(obstacleGrid,i,j+1)){
            return true;
        }
        lists.remove(lists.size()-1);
        return false;
    }
    @Test
    public void test(){
        int[][]obs=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        List<List<Integer>>lis=pathWithObstacles(obs);
        for(List<Integer>hh:lis){
            System.out.println(hh);
        }
    }
}
