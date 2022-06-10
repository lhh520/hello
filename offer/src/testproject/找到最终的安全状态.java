package testproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 找到最终的安全状态 {
    Set<Integer>set=new HashSet<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        for(int i=0;i< graph.length;i++){
            if(graph[i].length==0){
                set.add(i);
            }
        }
        return null;
    }

}
class Union{
    int[]parent;
    public Union(int n){
        //开始节点都是自己
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public void unit(int index1,int index2){
        int index_p1=find(index1);
        int index_p2=find(index2);
        parent[index_p2]=index_p1;
    }
    public int find(int index){
        if(index==parent[index]){
            return index;
        }else {
            return find(parent[index]);
        }
    }
}
