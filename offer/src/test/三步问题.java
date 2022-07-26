package test;


import java.util.*;

public class 三步问题 {
    int mod=1000000007;
    public int waysToStep(int n) {
        int[]dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        for(int i=3;i<n;i++){
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod+dp[i-3]%mod)%mod;
        }
        return dp[n-1];
    }
    public int numDistin(String s,String t){
        int m=s.length(),n=t.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
