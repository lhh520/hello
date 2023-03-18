package labuladong;

import org.junit.Test;

import java.util.*;

public class 数组中第K大的数字 {
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
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.poll();
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }
}
