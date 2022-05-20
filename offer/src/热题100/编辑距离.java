package 热题100;

import org.junit.Test;

public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][]dp=new int[m+1][n+1];//dp 表示的是 i 和 j 之间的的最小操作数
        //初始化操作
        if(word1.charAt(0)==word2.charAt(0)){
            dp[0][0]=0;
        }else {
            dp[0][0]=1;
        }
        for(int i=1;i<m;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<n;i++){
            dp[0][i]=i;
        }
        //开始循环遍历
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }else {
                    dp[i][j]=dp[i-1][j-1];
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
