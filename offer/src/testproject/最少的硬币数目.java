package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最少的硬币数目 {
//    public int coinChange(int[] coins, int amount) {
//        //背包问题
//        int[]dp=new int[amount+1];
//        dp[0]=1;
//        //对背包容量进行遍历
//        for(int i=0;i<coins.length;i++){
//            for(int j=coins[i];j<amount+1;j++){
//                dp[j]+=dp[j-coins[i]];
//            }
//        }
//        return dp[amount];
//    }
public int coinChange(int[] coins,int amount) {
    //递推表达式
    int[] dp = new int[amount + 1];
    Arrays.fill(dp,amount+1);
    dp[0]=0;
    for(int i=1;i<=amount;i++){
        for(int j=0;j<coins.length;j++){
            if(coins[j]<=i){
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
    }
    return dp[amount]>amount?-1:dp[amount];
}

    @Test
    public void test(){
        int[]coins=new int[]{1, 2, 5};
        System.out.println(coinChange(coins,11));
    }
}
