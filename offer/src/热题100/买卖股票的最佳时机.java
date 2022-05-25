package 热题100;

import org.junit.Test;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int low=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<prices.length;i++){
            //更新最小值
            low=Math.min(low,prices[i]);
            res=Math.max(res,prices[i]-low);
        }
        return res;
    }
    @Test
    public void test(){
        int[]nums=new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
