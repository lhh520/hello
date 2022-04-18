package offertest1;

import java.util.*;

public class offer06 {
    public boolean isBipartite(int[][] graph) {
       int n=graph.length;
       int[]visited=new int[n];
       for(int i=0;i<n;i++){
           if(visited[i]==0&&!dfs(graph,visited,i,1)){
               return false;
           }
       }
       return true;
    }
    public boolean dfs(int[][]graph,int[]visited,int index,int color){
        if(visited[index]!=0)
            return visited[index]==color;
        visited[index]=color;
        for(int i=0;i<graph[index].length;i++){
            if(!dfs(graph,visited,graph[index][i],-color))
                return false;
        }
        return true;
    }
    //广度优先遍历


}
