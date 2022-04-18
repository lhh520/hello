package test;



import com.sun.tools.javac.util.Pair;

import java.util.HashMap;

public class test63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //i,j
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)
            return 0;
        HashMap<Pair,Integer>map=new HashMap<>();
        return dfs(map,obstacleGrid,0,0);
    }
    public int dfs(HashMap<Pair,Integer>map,int[][] obstacleGrid,int i,int j)
    {   Pair p=new Pair(i,j);
        if(map.containsKey(p))
            return map.get(p);
        if(i>=obstacleGrid.length||j>=obstacleGrid[0].length||obstacleGrid[i][j]==1)
            return 0;
        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        int res=dfs(map,obstacleGrid,i+1,j)+dfs(map,obstacleGrid,i,j+1);
        map.put(p,res);
        return res;
    }

}
