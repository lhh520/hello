package dp;

import org.junit.Test;

import java.util.Arrays;

public class test343 {
    public int integerBreak(int n) {
    //dp[i]=Math.max()
        if(n==1)
            return 1;
        int[]dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=Integer.MIN_VALUE;
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    @Test
    public void test(){
        int n=integerBreak(10);
        System.out.println(n);
    }
}
