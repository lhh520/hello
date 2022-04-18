package offertest1;

public class offer10 {
    public int numWays(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
       int[]dp=new int[n+1];
       dp[0]=1;
       dp[1]=1;
       dp[2]=2;
       if(n<2)
           return dp[n];
       for(int i=2;i<n;i++){
           dp[i]=dp[i-1]+dp[i-2];
       }
       return dp[n];
    }
}
