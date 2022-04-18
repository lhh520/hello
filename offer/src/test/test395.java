package test;

import org.junit.Test;

import java.util.*;

public class test395 {
    public String frequencySort(String s) {
     //   System.out.println(1);
    char[]chars=s.toCharArray();
    List<Character>list=new ArrayList<>();
    HashMap<Character,Integer>map=new HashMap<>();
        for (int i = 0; i <chars.length; i++) {
            int c=map.getOrDefault(chars[i],0)+1;
            map.put(chars[i],c);
            list.add(chars[i]);
        }
        /*Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int a=map.get(o1);
                int b=map.get(o2);
                return b-a;
            }
        });*/
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
       // System.out.println();
    }
    @Test
    public void test()
    {
        String s="loveleetcode";
       String aa= frequencySort(s);
        System.out.println(aa);
    }
}
