package testproject;

import org.junit.Test;

public class 将字符串翻转到单调递增 {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        //dp[i][0]表示前i个元素，最后元素元素为0的最小反转次数
        //dp[i][1]表示前
        int[][]dp=new int[n][2];
        //初始化
        dp[0][0]=s.charAt(0)=='0'?0:1;
        dp[0][1]=s.charAt(0)=='1'?0:1;
        //状态转移
        for(int i=1;i<s.length();i++){
            dp[i][0]=dp[i-1][0]+(s.charAt(i)=='0'?0:1);
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+(s.charAt(i)==1?0:1);
        }
        return Math.min(dp[n-1][0],dp[n-1][1]);
    }
    @Test
    public void test(){
        String s= "00110";
        System.out.println(minFlipsMonoIncr(s));
    }
}
