package dp;

public class sss {
    public int numberOfTree (int n) {
        // write code here
        if(n<3){
            return n;
        }
        long temp=(long)Math.pow(10,9)+7;
        long[]dp=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            long count=0;
            for(int j=1;j<=i;j++){
                count+=dp[j-1]*dp[i-j]%temp;
            }
            dp[i]=count%temp;
        }
        return (int)dp[n];
    }
}
