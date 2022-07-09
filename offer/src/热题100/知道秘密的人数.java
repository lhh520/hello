package 热题100;

public class 知道秘密的人数 {
    int MOD = (int) 1e9 + 7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int cntB=0;//表示不能传播的人
        int[]dp=new int[n];//表示可以产生利息的人
        dp[0]=1;
        for(int i=0;i<n;i++){
            if(i+delay>=n) cntB=(cntB+dp[i])%MOD;
            for(int j=i+delay;j<Math.min(i+forget,n);j++){
                dp[j]=(dp[i]+dp[j])%MOD;
            }
        }
        return (dp[n-1]+cntB)%MOD;
    }
}
