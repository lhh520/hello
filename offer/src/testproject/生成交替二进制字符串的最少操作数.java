package testproject;

public class 生成交替二进制字符串的最少操作数 {
    public int minOperations(String s) {
        int len=s.length();
        int[][]dp=new int[len+1][2];
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='0'){
                dp[i+1][0]=dp[i][1];
                dp[i+1][1]=dp[i][0]+1;
            }else {
                dp[i+1][0]=dp[i][1]+1;
                dp[i+1][1]=dp[i][1];
            }
        }
        return Math.min(dp[len][0],dp[len][1]);
    }
}
