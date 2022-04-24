package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums){
        int n=nums.length;
        int[]dp=new int[n];
        if(n==1)
            return 1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
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
        int[]nums=new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
