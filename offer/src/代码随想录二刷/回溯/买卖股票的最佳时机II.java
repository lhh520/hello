package 代码随想录二刷.回溯;

import org.junit.Test;

public class 买卖股票的最佳时机II {
    public int maxProfit(int[] prices){
        int len=prices.length;
        int[][]dp=new int[len][2];
        dp[0][0]=-prices[0];//表示第一天为持有状态
        dp[0][1]=0;//股票为卖出状态
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);//当天持有 等于之前的卖出的收益 加上当天的收益
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);//当天卖出 等于之前的持有收益加上当前的收益
        }
        return dp[len-1][1];
    }
    @Test
    public void test(){
        int[]prices=new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
