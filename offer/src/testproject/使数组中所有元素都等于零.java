package testproject;

import org.junit.Test;

import java.util.*;

public class 使数组中所有元素都等于零 {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                pq.add(nums[i]);
            }
        }
        while(!pq.isEmpty()){
            n++;
            int cur=pq.poll();//选出最小值
            List<Integer>list=new ArrayList<>();
            while (!pq.isEmpty()){
                int next=pq.poll()-cur;
                if(next!=0){
                    list.add(next);
                }
            }
            if(list.size()==0){
                return n;
            }
            for(int i=0;i<list.size();i++){
                pq.add(list.get(i));
            }
        }
        return n;
    }
    public int minimumOperations1(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                set.add(nums[i]);
            }
        }
        return set.size();
    }
    @Test
    public void test(){
        int[]nums=new int[]{0};
        System.out.println(minimumOperations(nums));
    }
}
