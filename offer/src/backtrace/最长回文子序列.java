package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s){
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        String s2=sb.reverse().toString();
        System.out.println(s2);
        int[][]dp=new int[len+1][len+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len][len];
    }
    @Test
    public void test(){
        String s="bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
