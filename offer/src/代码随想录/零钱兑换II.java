package 代码随想录;

import org.junit.Test;

public class 零钱兑换II {
    public int change(int amount, int[] coins) {
        int[]dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
    @Test
    public void test(){
        int amount = 5;
        int[]coins =new int[]{1, 2, 5};
        System.out.println(change(amount,coins));
    }
}
