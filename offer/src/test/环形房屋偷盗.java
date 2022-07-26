package test;

import org.junit.Test;
import sun.tools.jstack.JStack;

public class 环形房屋偷盗 {
    public int rob(int[] nums) {
        //从0-n-1
        //从1 到n
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int n=nums.length;
        int l1=robb(nums,0,n-2);
        int l2=robb(nums,1,n-1);
        return Math.max(l1,l2);
    }
    public int robb(int[] nums,int left,int right){
        int len=right-left+1;
        int[]dp=new int[nums.length];
        dp[left]=nums[left];
        dp[left+1]=Math.max(dp[left],nums[left+1]);
        for(int i =left+2; i<=right; i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[right];
    }
    @Test
    public void test(){
        int[]nums =new int[]{2,3,2};
        System.out.println(rob(nums));
    }
}
