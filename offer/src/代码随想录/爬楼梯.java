package 代码随想录;

import org.junit.Test;

public class 爬楼梯 {
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=2;
        if(n<=2){
            return dp[n-1];
        }
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    @Test
    public void test(){
        System.out.println(climbStairs(1));
    }
}
