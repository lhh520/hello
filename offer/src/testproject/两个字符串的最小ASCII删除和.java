package testproject;

import org.junit.Test;

public class 两个字符串的最小ASCII删除和 {
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        char[]ss1=s1.toCharArray();
        char[]ss2=s2.toCharArray();
        int[][]dp=new int[m+1][n+1];
        dp[0][0]=0;
        //已经初始化
        for(int i=1;i<=m;i++){
            int cur=(ss1[i-1]);
            dp[i][0]=dp[i-1][0]+cur;
        }
        for(int i=1;i<=n;i++){
            int cur=(ss2[i-1]);
            dp[0][i]=dp[0][i-1]+cur;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(ss1[i-1]==ss2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1]+(ss1[i-1])+(ss2[j-1]),Math.min(dp[i-1][j]+(ss1[i-1]),dp[i][j-1]+(ss2[j-1])));
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String s1 = "sea", s2 = "eat";
        System.out.println(minimumDeleteSum(s1,s2));
    }
}
