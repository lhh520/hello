package test;

import java.util.Arrays;

public class test1039 {
    public int minScoreTriangulation(int[] values) {
    int n=values.length;
    int[][]dp=new int[n][n];
    for(int i=0;i<n;i++)
        Arrays.fill(dp[i],0xfffffff);
    for(int len=1;len<=n;len++)//枚举区间的长度
    {
        for(int le=0;le+(len-1)<n;le++)//枚举区间的左端点
        {
            //计算区间的右端点
            int ri=le+(len-1);
            if(len==1||len==2)//区间的长度为1或者2，这为0
            {
                dp[le][ri]=0;
            }
            else
            {
                for(int mid=le+1;mid<ri;mid++)
                {
                    dp[le][ri]=Math.min(dp[le][ri],dp[le][mid]+values[le] * values[mid] * values[ri]+dp[mid][ri]);
                }
            }
        }
    }
        return dp[0][n - 1];
    }
}
