package testproject;

public class 买卖股票最佳时机 {
    public int maxProfit(int[] prices){
        int low=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<prices.length;i++){
            low=Math.min(prices[i],low);
            res=Math.max(res,prices[i]-low);
        }
        return res;
    }
    public int maxProfit1(int[] prices){
        int n=prices.length;
        int[][]dp=new int[n][2];
        dp[0][0]=-prices[0];//表示0时刻买入股票手上的钱
        dp[0][1]=0;//0时刻卖出股票后价值
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[n-1][1];
    }

}
