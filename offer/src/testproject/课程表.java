package testproject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 课程表 {
    List<List<Integer>> edges;
    int[] indeg;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        indeg=new int[numCourses];
        for(int[]info:prerequisites){
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<numCourses;++i){
            if(indeg[i]==0){//入度为0 表示可以直接先修
                queue.add(i);
            }
        }
        int visited=0;
        while (!queue.isEmpty()){
            ++visited;
            int u=queue.poll();
            for(int v:edges.get(u)){
                --indeg[v];
                if(indeg[v]==0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
