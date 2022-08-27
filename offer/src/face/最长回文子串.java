package face;

public class 最长回文子串 {
    public String longestPalindrome(String s){
        int len=s.length();
        boolean[][]dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        for(int j=0;j<len;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else {
                    dp[i][j]=false;
                }
            }
        }
        int max=0,startIndex=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j]&&j-i+1>max){
                    max=j-i+1;
                    startIndex=i;
                }
            }
        }
        return s.substring(startIndex,startIndex+max);
    }
}
