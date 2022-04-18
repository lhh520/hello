import org.junit.Test;

public class test122 {
    public int maxProfit(int[] prices) {
        int ans=0;
     for(int i=1;i<prices.length;i++)
     {
         if(prices[i]>prices[i-1])
         {
             ans=ans+(prices[i]-prices[i-1]);
         }
     }
       return ans;
    }
    public int minCount(int[] coins) {
        int sum=0;
       // System.out.println("e");
        for(int i=0;i<coins.length;i++)
        {  int temp=0;
            
            while(coins[i]>0)
            {
                temp++;
                coins[i]=coins[i]-2;
            }
            sum=sum+temp;
        }
        return sum;
    }
    @Test
    public void test()
    {
        int[] coins=new int[]{4,2,1};
        System.out.println(minCount(coins));
    }

}
