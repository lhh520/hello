package testproject;

import org.junit.Test;

public class 翻转字符 {
    public int minFlipsMonoIncr(String s) {
        int len=s.length();
        int[][]dp=new int[len][2];
        if(s.charAt(0)=='0'){
            dp[0][0]=0;
            dp[1][0]=1;
        }else {
            dp[0][0]=1;
            dp[1][0]=0;
        }
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                dp[i][0]=dp[i-1][0];//可以由两个转化而来，上一个为0和上一个为1
                dp[i][1]=Math.min(dp[i-1][0]+1,dp[i-1][1]+1);
            }else {
                dp[i][0]=dp[i-1][0]+1;//可以由两个转化而来，上一个为0和上一个为1
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1]);
            }
        }
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }
    @Test
    public void test(){
        String s = "010110";
        System.out.println(minFlipsMonoIncr(s));
    }
}
