package test;

import org.junit.Test;

import java.util.Arrays;

public class 商品折扣后的最终价格 {
    public int[] finalPrices(int[] prices) {
        int[]ans=new int[prices.length];
        for(int i=0;i<prices.length-1;i++){
            int nn=Integer.MAX_VALUE;
            for(int j=i+1;j<prices.length;j++){

                if(prices[j]<=prices[i]){
                    nn=prices[j];
                    //System.out.println(nn);
                    break;
                }

            }
            ans[i]=nn==Integer.MAX_VALUE?prices[i]:prices[i]-nn;
        }
        ans[prices.length-1]=prices[prices.length-1];
        return ans;
    }
    @Test
    public void test(){
        int[]price=new int[]{8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(price)));
    }
}
