package 代码随想录;

import org.junit.Test;

public class 整数拆分 {
    public int integerBreak(int n) {
        if(n==1){
            return 1;
        }
        int[]dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=Integer.MIN_VALUE;
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(integerBreak(10));
    }
}
