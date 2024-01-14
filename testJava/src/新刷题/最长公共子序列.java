package 新刷题;

import org.junit.Test;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(),len2=text2.length();
        int[][]dp=new int[len1+1][len2+1];
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
    public int longestCommonSubsequence2(String text1, String text2) {
        // char[] char1 = text1.toCharArray();
        // char[] char2 = text2.toCharArray();
        // 可以在一開始的時候就先把text1, text2 轉成char[]，之後就不需要有這麼多爲了處理字串的調整
        // 就可以和卡哥的code更一致

        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= text1.length() ; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    @Test
    public void test(){
        System.out.println(longestCommonSubsequence( "abc","adc"));
    }
}
