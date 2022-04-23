package testproject;

import org.junit.Test;

public class 打家劫舍二 {
    public int rob(int[] nums){
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int r1=rob2(nums,1,nums.length-1);
        int r2=rob2(nums,0,nums.length-2);
        return Math.max(r1,r2);
    }
    //
    public int rob2(int[] nums,int start,int end){
        if(start==end)
            return nums[start];
        int[]dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,3,2};
        System.out.println(rob(nums));
    }
}
