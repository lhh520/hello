package test;

import org.junit.Test;

public class test795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    return count(nums,right)-count(nums,left-1);
    }
    public int count(int[]nums,int bound){
        int ans=0,cur=0;
        for(int x:nums){
            cur=x<=bound?cur+1:0;//如果持续大于0，则加1，数组加一，发现大于最大值，则置0
            ans=ans+cur;
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,9,2,5,6};
        int left=2;
        int right=8;
        System.out.println(numSubarrayBoundedMax(nums,left,right));
    }
}
