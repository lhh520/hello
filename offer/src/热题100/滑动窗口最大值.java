package 热题100;

import org.junit.Test;

import java.util.*;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<int[]>q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];
            }
        });
        for(int i=0;i<k;i++){
            q.add(new int[]{nums[i],i});
        }
        //结果存储
        int[]ans=new int[nums.length-k+1];
        ans[0]=q.peek()[0];
        for(int i=k;i< nums.length;i++){
            q.add(new int[]{nums[i],i});
            while (q.peek()[1]<i-k){//表明已经出去滑动窗口了
                q.poll();
            }
            ans[i-k+1]=q.peek()[0];
        }
        return ans;
    }
    //
    public int[] maxSlidingWindow12(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        //需要存储的结果数量
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
    //
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }





    @Test
    public void test(){
        int[]nums=new int[]{1,3,-1,-3,5,3,6,7};
        int[]uu=maxSlidingWindow1(nums,3);
        System.out.println(Arrays.toString(uu));
    }
}
