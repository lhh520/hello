package dp;

import java.util.Arrays;

public class test279 {
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i*i<=n;i++){//物品数量
            for(int j=i*i;j<=n;j++) {//背包中东西数量{}
              if(dp[j-i*i]!=Integer.MAX_VALUE){
                  dp[j]=Math.min(dp[j],dp[j-i*i]+1);
              }
            }
        }
        return dp[n];
    }
}
