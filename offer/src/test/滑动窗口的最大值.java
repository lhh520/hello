package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //用优先队列存储最大值
        PriorityQueue<Integer>pq=new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        //
        int[]ans=new int[nums.length];
        for(int i=0;i<k;i++){
            pq.add(nums[k]);
        }
        System.out.println(Arrays.toString(ans));
        for(int i=k+1;i<nums.length;i++){

        }
        return nums;
    }
    @Test
    public void test(){
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        maxSlidingWindow(nums,3);
    }
}
