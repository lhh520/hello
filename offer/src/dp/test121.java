package dp;

import org.junit.Test;

public class test121 {
    public int maxProfit(int[] prices) {
    int min=Integer.MAX_VALUE;//求出当前的最小值
    int ans=Integer.MIN_VALUE;
    for(int i=0;i<prices.length;i++){
        min=Math.min(min,prices[i]);
        ans=Math.max(ans,prices[i]-min);
    }
    return ans;
    }
    public int maxProfit1(int[] prices){
        if(prices==null||prices.length==0) return 0;
        int length=prices.length;
        int[][]dp=new int[length][2];
        int res=0;
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[length-1][1];
    }
    @Test
    public void test(){
        int[]nums=new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
