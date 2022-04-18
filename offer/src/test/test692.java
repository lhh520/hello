package test;


import org.junit.Test;

import java.util.*;

public class test692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        Set<String>set=new HashSet<>();
        List<String>list=new ArrayList<>();
        for (int i = 0; i <words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i],0)+1);
            if(set.add(words[i]))
                list.add(words[i]);
        }
        //int index=list.indexOf()
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a=map.get(o1);
                int b=map.get(o2);
                if(a==b)
                {
                    int c=list.indexOf(o1);
                    int d=list.indexOf(o2);
                    return o1.compareTo(o2);
                }
                return b-a;
            }
        });
        List<String>list1=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            list1.add(list.get(i));
        }
        return list1;
    }
    @Test
    public void test()
    {
        String[]strings=new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(strings,3).toString());
    }
}
