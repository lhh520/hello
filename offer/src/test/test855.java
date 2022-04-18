package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test855 {
    public String[] uncommonFromSentences(String s1, String s2) {
    String[]words=s1.split(" ");
        String[]words2=s2.split(" ");
        List<String>list=new ArrayList<>();
        HashMap<String,Integer>map=new HashMap<>();
        HashMap<String,Integer>map1=new HashMap<>();
        for (int i = 0; i <words.length; i++) {
            //System.out.println(words[i]);
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for (int i = 0; i <words2.length; i++) {
            //System.out.println(words[i]);
            map1.put(words2[i],map1.getOrDefault(words2[i],0)+1);
        }
        for(Map.Entry<String,Integer>entry: map.entrySet())
        {
             if((entry.getValue()==1&&!map1.containsKey(entry.getKey())))
              list.add(entry.getKey());
        }
        for(Map.Entry<String,Integer>entry1: map1.entrySet())
        {
            if((entry1.getValue()==1&&!map.containsKey(entry1.getKey())))
                list.add(entry1.getKey());
        }
        String[]ans=new String[list.size()];
        for (int i = 0; i <list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
    @Test
    public void test()
    {
        String s1="this apple is sweet";
        String s2="this apple is sour";
        String[]ans=uncommonFromSentences(s1,s2);
        System.out.println(ans[0].toString());
        System.out.println(ans[1].toString());
    }
}
