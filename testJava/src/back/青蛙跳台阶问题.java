package back;

import org.junit.Test;

public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(numWays(7));
    }
}
