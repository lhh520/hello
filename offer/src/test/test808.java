package test;

public class test808 {
    public double soupServings(int N) {
    N=N/25+(N%25==0?0:1);
    if(N>=200) return 1.0;
    double[][] dp=new double[N+1][N+1];
    //dp[i][j]表示i和j剩余时候的对应的概率，则dp[0][0]=0.5,此时A和B一起结束
    //初始化
    dp[0][0]=0.5;
    //当A先结束，则应该记为0
    for(int j=1;j<=N;++j)
        dp[0][j]=1;
    for(int i=0;i<=N;++i)
    {
        for(int j=1;j<=N;++j)
        {
           dp[i][j]+=dp[Math.max(i-4,0)][j];
           dp[i][j]+=dp[Math.max(i-3,0)][j-1];
           dp[i][j]+=dp[Math.max(i-2,0)][Math.max(j-2,0)];
           dp[i][j]+=dp[i-1][Math.max(j-3,0)];
           dp[i][j]/=4;
        }
    }
    return dp[N][N];
    }
}
