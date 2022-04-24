package testproject;

public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices){
        int len=prices.length;
        int[][]dp=new int[len][2];
        dp[0][0]=-prices[0];//持有股票的最大收益
        dp[0][1]=0;//卖出股票的最大收益
        for(int i=1;i<len;i++){
            //如果持有股票，则当前收益就是之前不持有股票的收益减去股票的价格
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            //如果选择不持有股票，则当前收益就是持有股票的收益加上今天的价格
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[0]);
        }
        //返回值
        return dp[len-1][1];
    }
}
