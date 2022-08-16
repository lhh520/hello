package 代码随想录二刷.动态规划;

import org.junit.Test;

public class 不同的子序列 {
    public int numDistinct(String s, String t){
        int m=s.length(),n=t.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
