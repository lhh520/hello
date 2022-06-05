package test;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        //System.out.println(pq.peek());
        while (k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }
}
