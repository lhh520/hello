package test;

import org.junit.Test;

public class 编辑距离 {
    public int minDistance(String word1, String word2){
        //给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
        //
        //你可以对一个单词进行如下三种操作：
        //
        //插入一个字符
        //删除一个字符
        //替换一个字符
        int m=word1.length(),n=word2.length();
        int[][]dp=new int[m+1][n+1];
        //动态规划数组
        for(int i=0;i<m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //插入一个字符
                    //删除一个字符
                    //替换一个字符
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
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
