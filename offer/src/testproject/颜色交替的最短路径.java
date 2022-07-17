package testproject;

import java.util.*;

public class 颜色交替的最短路径 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[] redList =new ArrayList[n];
        ArrayList<Integer>[] blueList =new ArrayList[n];
        for(int i=0;i<n;i++){
            redList[i]=new ArrayList<Integer>();
            blueList[i]=new ArrayList<Integer>();
        }
        for(int[]edg:redEdges){
            redList[edg[0]].add(edg[1]);
        }
        for(int[]edg:blueEdges){
            blueList[edg[0]].add(edg[1]);
        }
        boolean[]redVisited=new boolean[n];
        boolean[]blueVisited=new boolean[n];
        Queue<int[]>queue=new LinkedList<>();
        //初始0可以走红色和蓝色两条路
        queue.add(new int[]{0, 0, 0});//坐标 蓝色还是红色 以及长度
        queue.add(new int[]{0, 1, 0});
        redVisited[0] = true; //标记访问
        blueVisited[0] = true; //标记访问
        int[] res = new int[n];//长度
        Arrays.fill(res, -1);
        while (!queue.isEmpty()){
            int[]x=queue.poll();
            int v=x[0],color=x[1],len=x[2];
            if(res[v]==-1){//表示还没有搜索过
                res[v]=len;
            }
            if(color==0){
                for(int w:blueList[v]){
                    if(!blueVisited[w]){
                        blueVisited[w]=true;
                        queue.add(new int[]{w,1,len+1});
                    }
                }
            }else {
                for(int w:redList[v]){
                    if(!redVisited[w]){
                        redVisited[w]=true;
                        queue.add(new int[]{w,0,len+1});
                    }
                }
            }
        }
        return res;

    }
}
