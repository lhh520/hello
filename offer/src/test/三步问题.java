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
}
