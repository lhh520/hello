import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class test322 {
    int[] memo;
    int res=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount)
    {
    if(coins.length==0)
        return -1;
    findway(coins,amount);
    if(res==Integer.MAX_VALUE)
        return -1;
    return  res;
    }
    public int findway(int[] coins,int amount)
    {
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        if(memo[amount-1]!=0)
            return memo[amount-1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++)
        {
            //findway(coins,amount-coins[i],count+1);
            int res=findway(coins,amount-coins[i]);
            if(res>=0&&res<min)
            {
                min=res+1;
            }
        }
        memo[amount-1]=(min==Integer.MAX_VALUE?-1:min);
        return memo[amount-1];
    }

    @Test
    public void test()
    {

    }
}
