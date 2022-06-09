package testproject;

import org.junit.Test;

import java.util.*;

public class 分割数组为连续子序列 {
    public boolean isPossible(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Integer>pq=new PriorityQueue<>();//用来时刻维护最小值
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(!pq.contains(nums[i])){
                pq.add(nums[i]);
            }
        }
        System.out.println(pq.peek());
        while (!pq.isEmpty()){//不为空 则可以一直弹出
            while (pq.size()>0&&map.getOrDefault(pq.peek(),0)<=0){
                pq.poll();
            }
            if(pq.size()<=0){
                break;
            }
            int cur=pq.poll();
            if(map.getOrDefault(cur,0)>0){
                int num=map.get(cur);
                map.put(cur,0);
                if(map.getOrDefault(cur+1,0)<num||map.getOrDefault(cur+2,0)<num){
                    return false;
                }
                map.put(cur+1,map.get(cur+1)-num);
                map.put(cur+2,map.get(cur+2)-num);
            }
        }
        return true;
    }
    //
    public boolean isPossible1(int[] nums){
        Map<Integer,PriorityQueue<Integer>>map=new HashMap<>();//以x结尾的小顶堆
        for(int x:nums){
            if(!map.containsKey(x)){
                map.put(x,new PriorityQueue<Integer>());
            }
            if(map.containsKey(x-1)){
                int prevLength=map.get(x-1).poll();//对以x-1结尾的长度增长
                if(map.get(x-1).isEmpty()){
                    map.remove(x-1);
                }
                map.get(x).offer(prevLength+1);
            }else {
                map.get(x).offer(1);
            }
        }
        for(Map.Entry<Integer,PriorityQueue<Integer>>entry:map.entrySet()){
            PriorityQueue<Integer>queue=entry.getValue();
            if(queue.peek()<3){
                return false;
            }
        }
        return true;
    }
    //贪心算法 尽量不要创建新的短数组
    public boolean isPossible2(int[] nums){
       Map<Integer,Integer>countMap=new HashMap<>();
        Map<Integer,Integer>endMap=new HashMap<>();
        for(int x:nums){
            countMap.put(x,countMap.getOrDefault(x,0)+1);
        }
        for(int x:nums){
            int count=countMap.getOrDefault(x,0);
            if(count>0){
                int prevEndcount=endMap.getOrDefault(x-1,0);
                if(prevEndcount>0){
                    countMap.put(x,count-1);//被使用一次
                    endMap.put(x-1,prevEndcount-1);//以上个节点为最后一个节点的数据少一个
                    endMap.put(x,endMap.getOrDefault(x,0)+1);//以当前节点为最后一个节点增加1
                }else {//表示需要新建一个了
                    int count1=countMap.getOrDefault(x+1,0);
                    int count2=countMap.getOrDefault(x+2,0);
                    if(count1>0&&count2>0){
                        countMap.put(x,count-1);//当前的值减去1
                        countMap.put(x+1,count1-1);
                        countMap.put(x+2,count2-1);
                        endMap.put(x+2,endMap.getOrDefault(x+2,0)+1);
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,3,4,5};
        System.out.println(isPossible1(nums));
    }
}
