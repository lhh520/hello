package dp;

public class test96 {
    public int numTrees(int n) {
    if(n<=2)
        return n;
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
    public  void testweightbagproblem(int[] weight, int[] value, int bagsize){
        int wlen=weight.length,value0=0;
        int[][]dp=new int[wlen+1][bagsize+1];
        for(int i=0;i<=wlen;i++){
            dp[i][0]=value0;
        }
        for(int i=1;i<=wlen;i++){
            for(int j=1;j<=bagsize;j++){
                if(j<weight[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]+value[i-1]]);
                }
            }
        }
    }

}
