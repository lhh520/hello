package testproject;

import org.junit.Test;

public class 最长等差数列 {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n][1001];
        int maxLen=0;
        for(int k=1;k<n;k++){
            for(int j=0;j<k;j++){
                int d=nums[k]-nums[j]+500;//加上偏移量 使得结果不为负数
                dp[k][d]=dp[j][d]+1;
                maxLen=Math.max(maxLen,dp[k][d]);
            }
        }
        return maxLen+1;
    }
    @Test
    public void test(){
        int[]nums =new int[]{3,6,9,12};
        System.out.println(longestArithSeqLength(nums));
    }
}
