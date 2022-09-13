package plan92.test;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices){
        int len=prices.length;
        if(len==0) return 0;
        int[][]dp=new int[len][2];
        dp[0][0]=-prices[0];//表示持有股票，获得的收益
        dp[0][1]=0;//表示不持有股票的收益
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return dp[len-1][1];
    }
}
