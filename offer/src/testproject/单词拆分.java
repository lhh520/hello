package testproject;

import java.util.List;

public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[]dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(wordDict.contains(j-i)&&dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }
}
