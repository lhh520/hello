package test;

public class 买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[][]dp=new int[len][2];
        dp[0][0]=-prices[0];
        dp[1][0]=0;//表示今天股票为卖出状态
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[len-1][1];
    }
}
