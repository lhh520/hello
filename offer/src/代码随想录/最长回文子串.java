package 代码随想录;

public class 最长回文子串 {
    public String longestPalindrome(String s){
        int len=s.length();
        boolean[][]dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        int max=1;
        int start=0;
        for(int j=1;j<len;j++){
            for(int i=0;i<len-1;i++){
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else {
                    if(j-i<2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>max){
                    max=j-i;
                    start=i;
                }
            }
        }
        return s.substring(start,start+max);
    }
}
