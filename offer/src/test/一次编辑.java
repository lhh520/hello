package test;

import org.junit.Test;

public class 一次编辑 {
    //first = "pale"
    //second = "ple"
    //编辑距离
    public boolean oneEditAway(String first, String second) {
        int m=first.length();
        int n=second.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=1;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(first.charAt(i-1)==second.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        //System.out.println(dp[m][n]);
        return dp[m][n]<=1;
    }
    @Test
    public void test(){
        //"intention"
        //"execution"
        String first = "intention" ,second = "execution";
        System.out.println(oneEditAway(first,second));
    }
}
