package test;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices){
        int low=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<prices.length;i++){
            low=Math.min(low,prices[i]);
            res=Math.max(res,prices[i]-low);
        }
        return res;
    }
    public int maxProfit1(int[] prices){
        int n=prices.length;
        int[]dp=new int[n];
        dp[0]=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            dp[i]=(dp[i-1]<prices[i])?dp[i-1]:prices[i];//到i为止的最小值
            max=(prices[i]-dp[i])>max?prices[i]-dp[i]:max;
        }
        return max;
    }
    public int maxProfit2(int[] prices){
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
