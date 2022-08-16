package 代码随想录二刷.动态规划;

import java.util.Arrays;

public class 最长重复子数组 {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int[][]dp=new int[m+1][n+1];//i-1 j-1 中的长度
        int result=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                result=Math.max(result,dp[i][j]);
            }
        }
        return result;
    }
}
