package test;

public class 不同的子序列 {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
