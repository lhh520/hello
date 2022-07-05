package test;

import java.util.LinkedList;
import java.util.Queue;

public class 二进制矩阵中的最短路径 {
    //问是否存在 考虑使用DFS 问最优路径 使用BFS
    public int shortestPathBinaryMatrix(int[][] grid){
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
        int m=grid.length;
        int n=m;
        boolean[][]vis=new boolean[m][n];
        Queue<int[]>queue=new LinkedList<>();
        int dis=1;
        if(grid[0][0]!=0){
            return -1;
        }
        if(m==1){
            return 1;
        }
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int c=0;c<size;c++){
                int[]poll=queue.poll();
                int i=poll[0];
                int j=poll[1];
                for(int k=0;k<dir.length;k++){
                    int ni=i+dir[k][0];
                    int nj=j+dir[k][1];
                    if(ni>=0&&ni<m&&nj>=0&&nj<=n&&!vis[ni][nj]&&grid[ni][nj] == 0 ){
                        if(ni==m-1&&nj==n-1){
                            return dis+1;
                        }
                        queue.add(new int[]{ni,nj});
                        vis[ni][nj]=true;
                    }
                }
            }
            dis++;
        }
        return -1;
    }
}
