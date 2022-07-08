package test;

import org.junit.Test;

public class 买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        //1.不操作
        //2.第一次买入
        //3.第一次卖出
        //4.第二次买入
        //5.第二次卖出
        int len=prices.length;
        int[][]dp=new int[len][5];
        dp[0][0]=0;//无操作 自然
        dp[0][1]=-prices[0];//第一次买入
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=0;
        for(int i=1;i<len;i++){
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);//第一次买入
            //第一次卖出
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);//
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[len-1][4];
    }
    @Test
    public void test(){
        int[]prices =new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}
