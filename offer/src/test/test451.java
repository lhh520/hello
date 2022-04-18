package test;

import java.util.*;

public class test451 {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        List<Character> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int num1=map.get(o1);
                int num2=map.get(o1);
                return num1>num2?1:-1;
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
