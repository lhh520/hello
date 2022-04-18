package dp;

public class test647 {
    public int countSubstrings(String s) {
        int len=s.length();
        boolean[][]dp=new boolean[len][len];
        int res=0;
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        res++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){
                        res++;
                        dp[i][j]=true;
                    }
                }
            }
        }
        return res;
    }
}
