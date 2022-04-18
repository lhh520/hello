package offertest1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class offer103 {
    int[]memo;
    public int coinChange(int[] coins, int amount) {
    if(amount<1)
        return 0;
    return find(coins,amount);
    }
    public int find(int[] coins, int rem){//记忆搜索
      if(rem<0){
          return -1;
      }
      if(rem==0){
          return 0;
      }
      if(memo[rem-1]!=0){
         return memo[rem-1];
      }
      int min=Integer.MAX_VALUE;
      for(int i=0;i<coins.length;i++){
          int res=find(coins,rem-coins[i]);
          if(res>=0&&res<min){
              min=res+1;
          }
      }
      memo[rem-1]=(min==Integer.MAX_VALUE?-1:min);
      return memo[rem-1];
    }
    //动态规划问题
    public int coinChanges(int[]coins,int amount){
        //自底向上进行动态规划
        if(coins.length==0){
            return -1;
        }
        //建立dp数组
        int[]memo=new int[amount+1];
        memo[0]=0;
        for(int i=0;i<=amount;i++){//从数字为0开始遍历
            int min=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&memo[i-coins[j]]<min){
                    min=memo[i-coins[j]]+1;
                }
            }
            memo[i]=min;
        }
        return memo[amount]==Integer.MAX_VALUE?-1:memo[amount];
    }
    @Test
    public void test(){
        int[]coins=new int[]{1};
        System.out.println(coinChange(coins,2));
    }
}
