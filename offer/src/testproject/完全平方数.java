package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 完全平方数 {
    public int numSquares(int n){
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        //dp[1]=1;
        for(int i=0;i*i<=n;i++){//先遍历物品，再遍历背包
            for(int j=i*i;j<=n;j++){
                if(dp[j-i*i]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(numSquares(1));
    }
}
