package 代码随想录二刷.动态规划;

public class 不同的二叉搜索树 {
    public int numTrees(int n){
        if(n<=2){
            return n;
        }
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]=dp[i]+dp[i-j]*dp[j-1];
            }
        }
        return dp[n];
    }
}
