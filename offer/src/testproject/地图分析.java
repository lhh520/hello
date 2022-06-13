package testproject;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 地图分析 {
    int[][]dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int maxDistance(int[][] grid) {
        int max=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        boolean hasOcan=false;
        int[]point=null;
        while (!queue.isEmpty()){
            point=queue.poll();
            int x=point[0],y=point[1];
            for(int i=0;i<4;i++){
                int nx=x+dirs[i][0];
                int ny=y+dirs[i][1];
                if(nx<0||nx>=m||ny<0||ny>=n||grid[nx][ny]!=0){
                    continue;
                }
                grid[nx][ny]=grid[x][y]+1;
                hasOcan=true;
                queue.offer(new int[]{nx,ny});
            }
        }
        if(point==null||!hasOcan){
            return -1;
        }
        return grid[point[0]][point[1]]-1;
    }

    @Test
    public void test(){
        int[][]grid =new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(maxDistance(grid));
    }
}
