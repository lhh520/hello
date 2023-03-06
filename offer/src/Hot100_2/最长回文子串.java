package Hot100_2;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][]dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int j=0;j< n;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        int max=0;
        int start=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]&&j-i+1>max){
                    max=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+max);
    }
}
