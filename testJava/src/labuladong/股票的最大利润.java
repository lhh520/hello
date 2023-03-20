package labuladong;

public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;i++){
                max=Math.max(prices[j]-prices[i],max);
            }
        }
        return max;
    }
}
