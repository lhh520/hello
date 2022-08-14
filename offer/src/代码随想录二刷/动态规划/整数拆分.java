package 代码随想录二刷.动态规划;

public class 整数拆分 {
    public int integerBreak(int n){
        //dp[i]表示 i被分为 i份形成的数字
        if(n==1){
            return 1;
        }
        int[]dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=Integer.MIN_VALUE;
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        return dp[n];
    }
}
