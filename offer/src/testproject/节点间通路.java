package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 节点间通路 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        HashMap<Integer, List<Integer>>map=new HashMap<>();
        //将数据进行保存
        for(int i=0;i<graph.length;i++){
            int[]temp=graph[i];
            if(map.containsKey(temp[0])){
                 List<Integer>list=map.get(temp[0]);
                 list.add(temp[1]);
                 map.put(temp[0],new ArrayList<>(list));
            }else {
                List<Integer>list=new ArrayList<>();
                list.add(temp[1]);
                map.put(temp[0],new ArrayList<>(list));
            }
        }
        //开始遍历
        if(!map.containsKey(start)){
            return false;
        }
        return dfs(map,start,target);
        }
    public boolean dfs(HashMap<Integer, List<Integer>>map,int start,int target){
        if(target==start)
            return true;
        if(!map.containsKey(start)){
            return false;
        }
        for(int i:map.get(start)){
            if(dfs(map,i,target))
                return true;
        }
        return false;
      }
      @Test
    public void test(){

      }
}

