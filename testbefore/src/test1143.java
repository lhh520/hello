import org.junit.Test;

import java.util.HashMap;
/*输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。*/
public class test1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {   char c1=text1.charAt(i-1);
            for(int j=1;j<=n;j++)
            {
                char c2=text2.charAt(j-1);
                if(c1==c2)
                    dp[i][j]=dp[i-1][j-1]+1;
                if(c1!=c2)
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
    @Test
    public void test()
    {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}
