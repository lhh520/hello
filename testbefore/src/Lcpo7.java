import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcpo7 {
    public boolean canPermutePalindrome(String s) {
       int[] str=new int[26];
       for(int i=0;i<s.length();i++)
       {
           str[s.charAt(i)-'a']++;
       }
       int flag=0;
       for(int i=0;i<26;i++)
       {
           if(str[i]%2!=0)
               flag++;
       }
       if(flag<=1)
       return true;
       else
           return false;
    }
    public boolean canPermutePalindrome1(String s)
    {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int flag=0;
        for(Map.Entry<Character,Integer>entry:map.entrySet())
        {
            int occ=entry.getValue();
            if(occ%2!=0)
                flag++;
        }
        if(flag<=2)
            return true;
        else
            return false;
    }
    @Test
    public void test()
    {
        System.out.println(canPermutePalindrome("abb"));
    }
}
