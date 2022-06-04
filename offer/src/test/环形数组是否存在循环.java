package test;

import org.junit.Test;

public class 环形数组是否存在循环 {
    int n;
    int[]nums;
    public boolean circularArrayLoop(int[] nums) {
        this.nums=nums;
        n=nums.length;
        for(int i=0;i<n;i++){
            if(check(i)) return true;
        }
        return false;
    }
    boolean check(int start){
        int cur=start;
        boolean flag=nums[start]>0;
        int k=1;
        while (true){
            if(k>n) return false;
            int next=((cur+nums[cur])%n+n)%n;
            if(flag&&nums[next]<0) return false;
            if(!flag&&nums[next]>0) return false;
            if(next==start) return k>1;
            cur=next;
            k++;
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,-1,1,2,2};
        System.out.println(circularArrayLoop(nums));
    }
}
