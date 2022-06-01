package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 最小高度树 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>res=new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        //建立节点的度表
        int[]degree=new int[n];
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        //建立出度入度表 节点添加
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;/*出度++*/
            map.get(edge[0]).add(edge[1]);/*添加相邻节点*/
            map.get(edge[1]).add(edge[0]);
        }
        //建立队列
        /*把所有出度为1的节点，也就是叶子节点入队*/
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()){
            res = new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*如果是叶子节点我们就入队*/
                        queue.offer(neighbor);
                    }
                }

            }
        }
        return res;
    }
}
