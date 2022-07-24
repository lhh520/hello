package testproject;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 重建序列 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n=nums.length;
        int[]indegree=new int[n+1];
        Set<Integer>[]graph=new Set[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new HashSet<Integer>();
        }
        for(int[]sequence:sequences){
            int size=sequence.length;
            for(int i=1;i<size;i++){
                int prev=sequence[i-1],next=sequence[i];
                if(graph[prev].add(next)){
                    indegree[next]++;//入度加1
                }
            }
        }
        System.out.println(1);
        Queue<Integer>queue=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        //
        while (!queue.isEmpty()){
            if(queue.size()>1){
                return false;
            }
            int num=queue.poll();
            Set<Integer>set=graph[num];
            for(int next:set){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[]nums =new int[]{1,2,3};
        int[][]sequences =new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(sequenceReconstruction(nums,sequences));
    }
}
