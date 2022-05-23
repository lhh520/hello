package 热题100;

import org.junit.Test;

public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        if(n<=2){
            return n;
        }
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]=dp[i]+dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        System.out.println(numTrees(3));
    }
}
