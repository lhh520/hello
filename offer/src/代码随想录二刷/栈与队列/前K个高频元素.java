package 代码随想录二刷.栈与队列;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>occ=new HashMap<>();
        for(int num:nums){
            occ.put(num,occ.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];//最小堆
            }
        });
        for(Map.Entry<Integer,Integer>entry:occ.entrySet()){
            int num=entry.getKey(),count=entry.getValue();
            if(pq.size()==k){
                if(count>pq.peek()[1]){
                    pq.poll();
                    pq.offer(new int[]{num,count});
                }
            }else {
                pq.offer(new int[]{num,count});
            }
        }
        int[]ret=new int[k];
        for(int i=0;i<k;i++){
            ret[i]=pq.poll()[0];
        }
        return ret;
    }
}
