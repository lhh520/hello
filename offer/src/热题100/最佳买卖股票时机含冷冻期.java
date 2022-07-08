package 热题100;

import org.junit.Test;

public class 最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[][]dp=new int[len][2];
        dp[0][0]=-prices[0];//买入股票的状态
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            if(i>=2){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-2][1]-prices[i]);
            }
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);

        }
        return dp[len-1][1];
    }
    @Test
    public void test(){
        int[]nusm=new int[]{1,2,3,0,2};
        System.out.println(maxProfit(nusm));
    }
}
