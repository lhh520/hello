package back;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int len=s.length();
        boolean[][]dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        for(int j=0;j<len;j++){
            for(int i=0;i<j;i++){
                //比较[i，j]之间
                if (s.charAt(i)==s.charAt(j)){
                    if(j-i<=2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        int max=0;
        int start=-1;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j]&&j-i+1>max){
                    max=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+max);
    }
}
