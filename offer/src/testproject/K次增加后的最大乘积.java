package testproject;

import org.junit.Test;

import java.util.PriorityQueue;

public class K次增加后的最大乘积 {
    public int maximumProduct(int[] nums, int k) {
        long ans=1,mod=1000000007;
        //创建最小堆
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->a-b);
        for(int n:nums) q.offer(n);
        while (k!=0){
            int m=q.poll()+1;
            q.offer(m);
            k--;
        }
        while (!q.isEmpty()){
            ans=ans*q.poll()%mod;
        }
        return (int)(ans%mod);
    }
    @Test
    public void test(){
        int[]nums=new int[]{6,3,3,2};
        System.out.println(maximumProduct(nums,2));
    }
}
