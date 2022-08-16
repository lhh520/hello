package 代码随想录二刷.动态规划;

import org.junit.Test;

public class 回文子串 {
    public int countSubstrings(String s) {
        int len=s.length(),ans=0;
        if(s==null||len<1){
            return 0;
        }

        boolean[][]dp=new boolean[len][len];
        //dp[i][j] 表示从 i到j是不是一个回文串
        for(int j=0;j<len;j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else {
                    dp[i][j]=false;
                }
            }
        }
        //
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j]) ans++;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        String ss = "abc";
        System.out.println(countSubstrings(ss));
    }
}
