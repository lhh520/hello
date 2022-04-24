package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    @Test
    public void test(){
        int[]nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
