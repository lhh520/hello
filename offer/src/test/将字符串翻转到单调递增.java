package test;

import org.junit.Test;

public class 将字符串翻转到单调递增 {
    public int minFlipsMonoIncr(String s){
        int len=s.length();
        int[][]dp=new int[len][2];
        //初始化
        if(s.charAt(0)=='0'){
            dp[0][0]=0;
            dp[0][1]=1;
        }else {
            dp[0][0]=1;
            dp[0][1]=0;
        }
        //
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                dp[i][0]=dp[i-1][0];
                dp[i][1]=Math.min(dp[i-1][0]+1,dp[i-1][1]+1);
            }else {
                dp[i][0]=dp[i-1][0]+1;
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1]);
            }
        }
        return Math.min(dp[len-1][1],dp[len-1][0]);
    }
    @Test
    public void test(){
        System.out.println(minFlipsMonoIncr("00110"));
    }
}
