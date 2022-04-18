package test;

import org.junit.Test;

import java.util.*;

public class test819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> list = Arrays.asList(banned);
        paragraph=paragraph.toLowerCase();
        String[] words = paragraph.split("[!?',;. ]");
        //System.out.println(1);
        Map<String,Integer>map=new HashMap<>();
        for (int i = 0; i <words.length; i++) {
            if(words[i].equals("")) {
                continue;
            }
            if(!list.contains(words[i]))
                map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        //System.out.println(map.size());
        int max=Integer.MIN_VALUE;
        String ans=null;
        for(Map.Entry<String,Integer>entry: map.entrySet())
        {
            int va=entry.getValue();
            if(max<va)
            {
                max=va;
                ans=entry.getKey();
            }
        }
        return ans;
    }
    @Test
    public void test()
    {
        String an="Bob. hIt, baLl";
        String[] a=new String[]{"bob", "hit"};
        System.out.println(mostCommonWord(an,a));
    }

}
