package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount){
        int[]dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){//先遍历物品，再遍历背包
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE)
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
    @Test
    public void test(){
        int[]coins=new int[]{2};
        int amount=3;
        System.out.println(coinChange(coins,amount));
    }
}
