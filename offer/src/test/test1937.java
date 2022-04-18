package test;

import org.junit.Test;

public class test1937 {
    public int waysToChange(int n) {
        int[]coins=new int[]{25, 10, 5, 1};
        int MOD=1000000007;
        int[]dp=new int[n+1];
        dp[0]=1;
        for(int c=0;c<4;c++){
            int coin=coins[c];
            for(int i=coin;i<=n;i++){
                dp[i]=(dp[i]+dp[i-coin])%MOD;
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(waysToChange(5));
    }
}
