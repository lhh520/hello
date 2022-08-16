package 代码随想录二刷.动态规划;

import org.junit.Test;

public class 编辑距离 {
    public int minDistance(String word1, String word2){
        int m=word1.length(),n=word2.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //删除第一个元素  删除两个元素
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1,word2));
    }
}
