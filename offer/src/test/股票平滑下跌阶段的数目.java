package test;

import org.junit.Test;

public class 股票平滑下跌阶段的数目 {
    public long getDescentPeriods(int[] prices) {
        int n= prices.length;
        long res=1;
        int prev=1;
        for(int i=1;i<n;i++){
            if(prices[i]==prices[i-1]-1){
                ++prev;
            }else {
                prev=1;
            }
            res+=prev;
        }
        return res;
    }
    @Test
    public void test(){
        int[]ans=new int[]{3,2,1,4};
        System.out.println(getDescentPeriods(ans));
    }
}
