package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 找到最终的安全状态 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>>rg=new ArrayList<>();
        for(int i=0;i<n;i++){
            rg.add(new ArrayList<>());
        }
        int[]outDeg=new int[n];
        for(int x=0;x<n;x++){
            for(int y:graph[x]){
                rg.get(y).add(x);
            }
            outDeg[x]=graph[x].length;
        }
        //
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outDeg[i]==0){
                queue.add(i);//将出度为0 全部加入进去
            }
        }
        while (!queue.isEmpty()){
            int y=queue.poll();
            for(int x:rg.get(y)){
                if(--outDeg[x]==0){
                    queue.add(x);
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(outDeg[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[][]graph=new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer>gg=eventualSafeNodes(graph);
        System.out.println(gg.toString());
    }
}
