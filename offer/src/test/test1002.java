package test;

import org.junit.Test;

import java.util.*;

public class test1002 {
    public List<String> commonChars(String[] words) {
        HashMap<Character,Integer>map=new HashMap<>();
        List<String>list=new ArrayList<>();
        Set<Character>set=new HashSet<>();
        for (int i = 0; i < words.length ; i++)
        {

            String temp=words[i];
            for (int j = 0; j < temp.length(); j++) {
                //if(set.add(temp.charAt(j)))
                map.put(temp.charAt(j),map.getOrDefault(temp.charAt(j),0)+1);
            }
            //set.clear();
        }
        for(Map.Entry<Character,Integer>entry: map.entrySet())
        {
            if(entry.getValue()!=0)
               list.add(entry.getKey().toString());
        }
        return list;
    }
    public List<String> commonChars1(String[] words)
    {
        int[]count=new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);
        for(int i=0;i<words.length;i++)
        {
            int[]temp=new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                char ch=words[i].charAt(j);
                temp[ch-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                count[j]=Math.min(count[j],temp[j]);
            }
        }
        List<String>list=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                list.add(String.valueOf((char) (i+'a')));
            }
        }
        return list;
    }
    @Test
    public void test()
    {
        String[] words=new String[]{"bella","label","roller"};
        List<String>list=commonChars1(words);
        System.out.println(list.toString());
    }
}
