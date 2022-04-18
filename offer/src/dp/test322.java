package dp;

import org.junit.Test;

import java.util.Arrays;

public class test322 {
    public int coinChange(int[] coins, int amount) {
    int[]dp=new int[amount+1];
    Arrays.fill(dp,Integer.MAX_VALUE);
    dp[0]=0;
    for(int i=0;i<coins.length;i++){
        for(int j=coins[i];j<=amount;j++){
            if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
    }
    if(dp[amount]==Integer.MAX_VALUE)
        return -1;
    else return dp[amount];
    }
    @Test
    public void test(){
        int[]coins=new int[]{1, 2, 5};
        System.out.println(coinChange(coins,11));
    }
}
