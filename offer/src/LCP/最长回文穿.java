package LCP;

public class 最长回文穿 {
    public String longestPalindrome(String s){
        int len=s.length();
        boolean[][]dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        //从 i到 j
        for(int j=0;j<len;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){//如果两端相等
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
        int max=0;
        int start=-1;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                max=j-i+1;
                start=i;
            }
        }
        return s.substring(start,start+max);
    }
}
