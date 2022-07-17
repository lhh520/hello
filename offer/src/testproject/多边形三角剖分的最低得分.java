package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 多边形三角剖分的最低得分 {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int len=1;len<=n;len++){//枚举区间的长度
            //枚举左节点
            for(int le=0;le+(len-1)<n;le++){
                //计算右边的节点
                int ri=le+(len-1);
                if(len==1||len==2){
                    dp[le][ri]=0;
                }else {
                    for(int mid=le+1;mid<ri;mid++){
                        dp[le][ri]=Math.min(dp[le][ri],dp[le][mid]+values[le]*values[mid]*values[ri]+dp[mid][ri]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,7,4,5};
        System.out.println(minScoreTriangulation(nums));
    }
}
