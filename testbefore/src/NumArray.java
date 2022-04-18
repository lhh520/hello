import org.junit.Test;

import java.util.*;

public class NumArray {
    public String[] findWords(String[] words) {
    //String s = "a,b,c,d,e,f";
        //
        //Set<String >actionSet = new HashSet<>(Arrays.asList(s.split(",")));
        String str1="qwertyuiop";
        String str2="asdfghjkl";
        String str3="zxcvbnm";
        List<String>ans=new ArrayList<>();
        Set<String > set1 = new HashSet<>(Arrays.asList(str1.split("")));
        Set<String > set2 = new HashSet<>(Arrays.asList(str2.split("")));
        Set<String > set3 = new HashSet<>(Arrays.asList(str3.split("")));
        for(String word:words)
        {
            if(check(set1,word)||check(set2,word)||check(set3,word))
                ans.add(new String(word));

        }
        String[] array2 = ans.toArray(new String[ans.size()]);
        return array2;
    }
    Boolean check(Set<String > set1,String word)
    {   word=word.toLowerCase();
        List<String> nu=Arrays.asList(word.split(""));
        for(int i=0;i<nu.size();i++)
        {
            if(!set1.contains(nu.get(i)))
                return false;
        }
        return true;
    }
    @Test
    public void test()
    {   String[] words=new String[]{"Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }
}
