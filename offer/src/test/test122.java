package test;

import org.junit.Test;

public class test122 {
    public int maxProfit(int[] prices) {
        int max=0;
    for(int i=0;i<prices.length-1;i++){
        max=max+Math.max(0,prices[i+1]-prices[i]);
    }
    return max;
    }
    @Test
    public void test(){
        int[]prices=new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
