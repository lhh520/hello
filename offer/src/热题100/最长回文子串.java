package 热题100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        //动态规划
        int len=s.length();

        boolean[][]dp=new boolean[len][len];
        dp[0][0]=true;
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        int max=Integer.MIN_VALUE;
        int start=0;
        for(int j=1;j<len;j++){
            for(int i=0;i<len-1;i++){
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else {
                    if(j-i<=2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>max){
                    max=j-i+1;
                    start=i;
                }

            }
        }
        return start==Integer.MIN_VALUE?"":s.substring(start,start+max);
    }
    @Test
    public void test(){
        //s = "babad"
        String ss="babad";
        System.out.println(longestPalindrome(ss));
    }
}
