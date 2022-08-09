package testproject;

import org.junit.Test;

import java.util.*;

public class 受限条件下可到达节点的数目 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //BFS
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int[]temp=edges[i];
            List<Integer>list=map.getOrDefault(temp[0],new ArrayList<>());
            list.add(temp[1]);
            map.put(temp[0],new ArrayList<>(list));
            //
            List<Integer>list1=map.getOrDefault(temp[1],new ArrayList<>());
            list1.add(temp[0]);
            map.put(temp[1],new ArrayList<>(list1));
        }
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<restricted.length;i++){
            set.add(restricted[i]);
        }
        Queue<Integer>queue=new LinkedList<>();
        queue.add(0);
        int ret=0;
        boolean[]vis=new boolean[n];
        while (!queue.isEmpty()){
            int cur=queue.poll();
            vis[cur]=true;
            ret++;
            List<Integer>list=map.getOrDefault(cur,new ArrayList<>());
            for(int num:list){
                if(!set.contains(num)&&!vis[num]){
                    queue.add(num);
                }
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int[][]edgs=new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[]res=new int[]{4,5};
        System.out.println(reachableNodes(7,edgs,res));
    }
}
