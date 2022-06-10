package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 所有可能的路径 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         dfs(graph,0);
         return lists;
    }
    public void dfs(int[][] graph,int index){
        if(index==graph.length-1){
            list.add(index);
            lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(index);
        int[]ii=graph[index];
        for(int i:ii){
            dfs(graph,i);
        }
        list.remove(list.size()-1);

    }
    @Test
    public void test(){
        int[][] graph=new int[][]{{1,2},{3},{3},{}};
        List<List<Integer>>li=allPathsSourceTarget(graph);
        for(List<Integer>ll:li){
            System.out.println(ll.toString());
        }
    }
}
