package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 最小体力消耗路径 {
    int[][]dirs=new int[][]{{1,0},{0,1}};
    int min=Integer.MAX_VALUE;
    boolean[][]visited;
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        visited=new boolean[m][n];
        dfs1(heights,0,0,-1,visited);

        return min;
    }
    public void dfs1(int[][] heights,int i,int j,int max,boolean[][]visited){
        if(i==heights.length-1&&j==heights[0].length-1){//已经到达了最右下角，则可以退出了
            min=Math.min(min,max);
            list.add(heights[i][j]);
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(heights[i][j]);
        visited[i][j]=true;
        for(int k=0;k<2;k++){
            int[]p=dirs[k];
            int newx=p[0]+i;
            int nexy=p[1]+j;
            if(newx>=0&&newx<heights.length&&nexy>=0&&nexy<heights[0].length&&!visited[newx][nexy]){
                max=Math.max(max,Math.abs(heights[newx][nexy]-heights[i][j]));
                dfs1(heights,newx,nexy,max,visited);
            }
        }

    }




    //dfs可以找到是否可以到达路径 但是无法找到最优的路径 因为不可避免的相四周
    @Test
    public void test(){
        int[][]heights =new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i).toString());
        }
    }
}
