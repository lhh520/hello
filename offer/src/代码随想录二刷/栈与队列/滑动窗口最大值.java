package 代码随想录二刷.栈与队列;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k){
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0];
            }
        });
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i});
        }
        int[]ans=new int[nums.length-k+1];
        ans[0]=pq.peek()[0];
        for(int i=k;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});//向其中添加数字
            while (pq.peek()[1]<=i-k){//过期的最大值 都给清理出去 保证最大值永远是最新的
                pq.poll();
            }
            ans[i-k+1]=pq.peek()[0];
        }
        return ans;
    }
}
