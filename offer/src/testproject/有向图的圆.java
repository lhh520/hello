package testproject;

import java.util.LinkedList;
import java.util.Queue;

public class 有向图的圆 {
    int ans=-1;
    public int longestCycle(int[] edges){
        boolean[]visited=new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                dfs(i,edges,visited,0);
            }
        }
        return ans;
    }
    public int[]dfs(int cur,int[]edgs,boolean[]visited,int len){
        int[]temp={-1,len};
        if(cur==-1){
            return temp;
        }
        if(visited[cur]){//表示当前的值被访问过，
            temp[0]=cur;
            return temp;
        }
        visited[cur]=true;
        int[]ring=dfs(edgs[cur],edgs,visited,len+1);
        if(ring[0]==cur){//如果当前值 是
            ans=Math.max(ring[1]-len,ans);
        }
        return ring;
    }
}
