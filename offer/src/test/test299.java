package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test299 {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer>map=new HashMap<>();
        char[] s1=secret.toCharArray();
        char[] s2=guess.toCharArray();
        int count1=0;
        for(int i=0;i<secret.length();i++)
        {
            if(s1[i]==s2[i])
            {
                count1++;
                s1[i]='#';
                s2[i]='*';
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            map.put(s1[i], map.getOrDefault(s1[i],0)+1);
        }
        int count2=0;
        System.out.println(9);
        for(int i=0;i<guess.length();i++)
        {
            if(map.containsKey(s2[i])&&s2[i]!='*'&&map.get(s2[i])>0)
            {
                count2++;
                //map.get(s2[i])=map.get(s2[i])-1;
                map.put(s2[i], map.get(s2[i])-1);
            }
        }
        //String ans=(char)count1+'A'+(char)count2+'B';
        StringBuilder sb=new StringBuilder();
        sb.append(count1);
        sb.append('A');
        sb.append(count2);
        sb.append('B');
        return sb.toString();
    }
    @Test
    public void test()
    {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(1,2);
        map.put(1,3);
        for(Map.Entry<Integer,Integer>entry: map.entrySet())
        {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
