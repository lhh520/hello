package face;
import org.junit.Test;

import java.util.*;
public class Solution1 {
    int[][]path;
    int len;
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public int DagPathNum (int[][] nodes) {
        // write code here
        path=nodes;
        len=path.length;
        list.add(0);
        dfs(0);
        return lists.size();
    }
    public void dfs(int index){
        if(index==len-1){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int next:path[index]){
            list.add(next);
            dfs(next);
            list.remove(list.size()-1);
        }
    }
    //[[1,2,3],[3],[3],[4],[]]
    @Test
    public void test(){
        int[][]node=new int[][]{{1,2,3},{3},{3},{4},{}};
        System.out.println(DagPathNum(node));
    }
}
