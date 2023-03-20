package labuladong;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(nums.length==0||k==0){
            return new int[0];
        }
//        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>(){
//            @Override
//            public int com
//        })
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o2[0]-o1[0];
                }
            }
        });
        //先将前k个数字放入优先队列中，向右移动窗口就再放入一个，此时堆顶元素就是最大值，如果这个之不在窗口内，就可以直接删除
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i});
        }
        int[]ans=new int[n-k+1];
        ans[0]=pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            while (pq.peek()[1]<=i-k){//说明不在窗口范围内
                pq.poll();
            }
            ans[i-k+1]=pq.peek()[0];
        }
        return ans;
    }
}
