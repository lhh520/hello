package hot100;
import java.util.*;
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[]val=new boolean[s.length()+1];
        val[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(wordDict.contains(s.substring(j,i))&&val[j]){
                    val[i]=true;
                }
            }
        }
        return val[s.length()];
    }
}
