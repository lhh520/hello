package 代码随想录二刷.动态规划;

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int m=s.length(),n=t.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        if(dp[m][n] == m){
            return true;
        }else{
            return false;
        }

    }
    @Test
    public void test(){
        String s="abc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
}
