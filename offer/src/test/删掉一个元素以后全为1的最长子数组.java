package test;

import org.junit.Test;

import java.util.Arrays;

public class 删掉一个元素以后全为1的最长子数组 {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        //滑动窗口
        int left=0,right=0;
        int count=0;
        int ans=0;
        while(right<n){
            count+=nums[right]==0?1:0;//用count来计算其中0的个数
            while (count>1){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }

            ans=Math.max(ans,right-left+1);
            right++;
        }

        return ans-1;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
}
