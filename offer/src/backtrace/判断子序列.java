package backtrace;

public class 判断子序列 {
    public boolean isSubsequence(String s, String t){
       int m=s.length(),n=t.length();
       int[][]dp=new int[m+1][n+1];
       for(int i=1;i<=m;i++){
           for(int j=1;j<=n;j++){
               if(s.charAt(i-1)==s.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1]+1;
               }else {
                   dp[i][j]=dp[i][j-1];
               }
           }
       }
       if(dp[m][n]==m){
           return true;
       }else {
           return false;
       }
    }
}
