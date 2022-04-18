package dp;

import java.util.HashMap;

public class test392 {
    public boolean isSubsequence(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),i);
        }
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
                return false;
            if(i>0&&map.get(s.charAt(i))<map.get(s.charAt(i-1)))
                return false;
        }
        return true;
    }
    public boolean isSubsequence1(String s, String t){
        int m=s.length();
        int n=t.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=dp[i][j-1];
            }
        }
        //
        if(dp[m][n]==m)
            return true;
        else
            return false;
    }
}
