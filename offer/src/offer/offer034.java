package offer;

import org.junit.Test;

import java.util.HashMap;

public class offer034 {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<order.length();i++)
        {
            map.put(order.charAt(i),map.getOrDefault(order.charAt(i),1)+1);
        }
        search:for(int i=0;i<words.length-1;i++)
        {
            String word1=words[i];
            String word2=words[i+1];
            for(int k=0;k<Math.min(word1.length(),word2.length());++k)
            {
                if(word1.charAt(k)!=word2.charAt(k))
                {
                    if(map.get(word1.charAt(k))>map.get(word2.charAt(k)))
                        return false;
                     continue search;
                }
            }
            if(word1.length()>word2.length())
                return false;
        }
    return true;
    }
    @Test
    public void test()
    {
        String[] a=new String[]{"hello","leetcode"};
        String t="hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(a,t));
    }
}
