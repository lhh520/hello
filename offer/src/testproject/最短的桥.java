package testproject;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 最短的桥 {
    Queue<int[]>queue=new LinkedList<>();
    int[][]dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        //先遍历找到岛屿 从岛屿出发  求距离
        int m=grid.length;
        int n=grid[0].length;
        boolean find=false;
        for(int i=0;i<m;i++){
            if(find){//只寻找其中一个岛屿
                break;
            }
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){//找到
                    find=true;
                    dfs(grid,i,j);
                }
            }
        }
        int res=0;
        //已经找到了第一个岛屿 并且将第一个岛屿附近的0都填入进去了
        while (!queue.isEmpty()){
            res++;
            int sz= queue.size();
            for(int i=0;i<sz;i++){
                int[]root=queue.poll();
                for(int k=0;k<dirs.length;k++){
                    int ni=root[0]+dirs[k][0];
                    int nj=root[1]+dirs[k][1];
                    if(ni>=0&&ni<m&&nj>=0&&nj<n){
                        if(grid[ni][nj]==1){
                            return res-1;
                        }else if(grid[ni][nj]==2){
                            continue;//表明还是第一座岛屿
                        }else {
                        grid[ni][nj]=2;
                        queue.add(new int[]{ni,nj});}
                    }
                }
            }
        }
        return res;
    }

    public void dfs(int[][]grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==2){//越界或者重复搜索 则直接返回
            return;
        }
        if(grid[i][j]==0){//周围的0
            queue.add(new int[]{i,j});
            return;
        }
        grid[i][j]=2;//遍历过的都设为2
        for(int k=0;k<dirs.length;k++){
            int ni=i+dirs[k][0];
            int nj=j+dirs[k][1];
            dfs(grid,ni,nj);
        }
    }
    @Test
    public void test(){
        int[][]nums=new int[][]{{0,0,1,0,1},{0,1,1,0,1},{0,1,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(shortestBridge(nums));
    }
}
