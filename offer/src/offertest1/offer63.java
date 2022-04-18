package offertest1;

import org.junit.Test;

public class offer63 {
    public int maxProfit(int[] prices) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                max=Math.max(prices[j]-prices[i],max);
            }
        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
