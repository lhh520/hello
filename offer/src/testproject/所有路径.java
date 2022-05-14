package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 所有路径 {
    List<List<Integer>>lists;
    List<Integer>list;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        lists=new ArrayList<>();
        list=new ArrayList<>();
        list.add(0);
        dfs(graph,0);
        return lists;
    }
    public void dfs(int[][]graph,int index){
        if(index==graph.length-1){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<graph[index].length;i++){
            list.add(graph[index][i]);//将数字放入进去
            dfs(graph,graph[index][i]);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        int[][]graph=new int[][]{{1,2},{3},{3},{}};
        List<List<Integer>> ans=allPathsSourceTarget(graph);

            System.out.println(ans.toString());

    }
}
