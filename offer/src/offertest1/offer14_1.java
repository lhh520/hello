package offertest1;

import org.junit.Test;

public class offer14_1 {
    public int cuttingRope(int n) {
    //将n分成三部分，暴力破解
        //int i=1,j=n-1;
        int[]dp=new int[n+1];
        dp[2]=1;//长度为2，最大为1
        for(int i=3;i<n+1;i++){//从3开始计算
            for(int j=2;j<i;j++){
                dp[i]=Math.max(dp[i]%1000000007,Math.max(j*(i-j)%1000000007,j*dp[i-j]%1000000007));
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        int j=cuttingRope(3);
        System.out.println(j);
    }
}
