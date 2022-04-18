import org.junit.Test;

import java.util.*;

public class test139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        Collections.sort(wordDict);
        for(int i=0;i<wordDict.size();i++)
     {   String temp=wordDict.get(i);
         s=s.replaceAll(temp,"");

     }
     if(s.length()==0)
         return true;
     else
         return  false;
    }
    public boolean wordBreak1(String s, List<String> wordDict)
    {
        boolean[] dp=new boolean[s.length()+1];
        Set<String>wo=new HashSet<>(wordDict);
        dp[0]=true;
        for(int i=1;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]&&wo.contains(s.substring(j,i)))
                    dp[i]=true;
                break;
            }
        }
        return dp[s.length()];
    }
    @Test
    public void test()
    {   //"cars"
//["car","ca","rs"]
        //s = "leetcode", wordDict = ["leet", "code"]
        //s = "applepenapple", wordDict = ["apple", "pen"]
        String s="cars";
        //System.out.println(s.replaceAll("leet",""));
        String[] wordDict1=new String[]{"car","ca","rs"};

        List<String>wordDict=new ArrayList<String>(Arrays.asList(wordDict1));
        System.out.println(wordBreak1(s,wordDict));
    }
}
