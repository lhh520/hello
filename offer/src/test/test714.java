package test;

public class test714 {
    public int maxProfit(int[] prices, int fee) {
    int res=0;
    int minprice=prices[0];
    for(int i=1;i<prices.length;i++){
        if(prices[i]<minprice){
            minprice=prices[i];
        }
        if(prices[i]>=minprice&&prices[i]<=minprice+fee){
            continue;
        }
        if(prices[i]>fee+minprice){
            res+=prices[i]-minprice-fee;
            minprice=prices[i]-fee;
        }
    }
    return res;
    }
}
