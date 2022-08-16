package 代码随想录二刷.动态规划;

import org.junit.Test;

import java.util.Arrays;

public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=1;
            }
        }
        int max=1;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
