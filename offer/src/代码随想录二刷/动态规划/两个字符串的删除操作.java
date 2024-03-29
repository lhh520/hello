package 代码随想录二刷.动态规划;

import org.junit.Test;

public class 两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){//如果相等 不需要删除
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1]+2,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    @Test
    public void test(){
        String word1 = "sea", word2 = "eat";
        System.out.println(minDistance(word1,word2));
    }
}
