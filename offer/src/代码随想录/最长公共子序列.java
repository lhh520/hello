package 代码随想录;

import org.junit.Test;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][]dp=new int[len1+1][len2+1];//表示前i中和j 有长度
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
    @Test
    public void test(){
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}
