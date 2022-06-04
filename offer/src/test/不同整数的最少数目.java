package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 不同整数的最少数目 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            pq.add(entry.getValue());
        }
        boolean flag=false;
        while (k>0){
            int cur=pq.poll();
            if(k>=cur){
               k=k-cur;
            }else {
               flag=true;
               break;
            }
        }
        return flag==true?pq.size()+1:pq.size();
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(nums,k));
    }
}
