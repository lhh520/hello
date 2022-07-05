package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 受标签影响的最大值 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n=values.length;
        int[][]group=new int[n][2];
        for(int i=0;i<n;i++){
            group[i][0]=values[i];
            group[i][1]=labels[i];
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>(((o1, o2) -> o2[0]-o1[0]));//价值从小到大排序
        for(int i=0;i<n;i++){
            pq.add(group[i]);
        }
        int res=0;
        Map<Integer,Integer>map=new HashMap<>();
        while (!pq.isEmpty()&&numWanted>0){
            int[]poll=pq.poll();
            int val=poll[0];
            int la=poll[1];
            if(map.getOrDefault(la,0)>=useLimit){
                continue;
            }
            map.put(la,map.getOrDefault(la,0)+1);
            //取当下的值
            res+=val;
            numWanted--;
        }
        return res;
    }
    @Test
    public void test(){
        int[]values =new int[]{5,4,3,2,1};
        int[]labels =new int[]{1,1,2,2,3};
        int numWanted = 3, useLimit = 1;
        System.out.println(largestValsFromLabels(values,labels,numWanted,useLimit));
    }
}
