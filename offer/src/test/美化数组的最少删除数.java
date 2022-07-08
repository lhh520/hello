package test;

import org.junit.Test;

public class 美化数组的最少删除数 {
    public int minDeletion(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;){
            int j=i+1;
            while (j<nums.length&&nums[j]==nums[i]){//如果没有遇到满足的条件 则一直向右
                j++;
            }
            if(j<nums.length)
            sum=sum+2;
            i=j+1;
        }
        return nums.length-sum;
    }
    @Test
    public void test(){
        //[1,1,2,2,3,3]
        int[]nums =new int[]{1,1,2,2,3,3};
        System.out.println(minDeletion(nums));
    }
}
