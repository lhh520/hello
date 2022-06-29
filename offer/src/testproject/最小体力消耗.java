package testproject;

import org.junit.Test;

import java.util.ArrayList;

public class 最小体力消耗 {
    int[][]dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights){
        int rows=heights.length;
        int cols=heights[0].length;
        int left=0;
        int right=1000000;
        while (left<right){
            int mid=(right+left)/2;
            if(dfs(heights,mid,0,0,new boolean[rows][cols])){
                    right=mid-1;
            }else {
                    left=mid+1;
            }

        }
        return left;
    }
    public boolean dfs(int[][] heights,int mid,int i,int j,boolean[][]visited){
        if(i==heights.length-1&&j==heights[0].length-1){//已经到达了最右下角，则可以退出了

            return true;
        }

        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int[]p=dirs[k];
            int newx=p[0]+i;
            int nexy=p[1]+j;
            if(newx>=0&&newx<heights.length&&nexy>=0&&nexy<heights[0].length&&!visited[newx][nexy]&&Math.abs(heights[newx][nexy]-heights[i][j])<=mid){
               if(dfs(heights,mid,newx,nexy,visited))
                   return true;
            }
        }
        return false;
    }
    @Test
    public void test(){
        int[][]heights =new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(minimumEffortPath(heights));

    }
}
