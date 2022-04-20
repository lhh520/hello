package Node;

import org.junit.Test;

public class offer14 {
    public int cuttingRope(int n) {
        //剪成三段是最好的
        int[]dp=new int[n+1];
        //初始化
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i-1;j++){
                //(i-j)*j 表示分为两段，dp[i-j]*j分为多段
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }
    public int cuttingRope2(int n) {
        if(n<4)
            return n-1;
        long res=1;
        while (n>4){
            res=(res*3)%1000000007;
            n=n-3;
        }
        return (int)(res*n%1000000007);
    }
    @Test
    public void test(){
        System.out.println(cuttingRope2(10));
    }
}
