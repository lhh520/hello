package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 移除最多的同行或同列石头 {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        List<List<Integer>>edge=new ArrayList<>();
        for(int i=0;i<n;i++){
            edge.add(new ArrayList<Integer>());
            for(int j=0;j<n;j++){
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    edge.get(i).add(j);
                }
            }
        }
        boolean[]vis=new boolean[n];
        int num=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                num++;
                dfs(i,edge,vis);
            }
        }
        return n-num;
    }
    public void dfs(int x,List<List<Integer>>edge,boolean[]vis){
        vis[x]=true;
        for (int y:edge.get(x)){
            if(!vis[y]){
                dfs(y,edge,vis);
            }
        }
    }
    @Test
    public void test(){

    }
}
