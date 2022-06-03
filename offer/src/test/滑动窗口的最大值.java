package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
            }
        });
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i});
        }
        int n=nums.length;
        int[]ans=new int[n-k+1];
        ans[0]=pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            while (pq.peek()[1]<=i-k){//已经到了左边了 应该弹出左边的
                pq.poll();
            }
            ans[i-k+1]=pq.peek()[0];
        }

        return ans;
    }
    @Test
    public void test(){
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        int[]pp=maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(pp));
    }
}
