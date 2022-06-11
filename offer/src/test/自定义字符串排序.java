package test;

import org.junit.Test;

import java.util.*;

public class 自定义字符串排序 {
    public String customSortString(String order, String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        List<Character>list=new ArrayList<>();
        StringBuilder bb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
            list.add(s.charAt(i));}
            else {
                bb.append(s.charAt(i));
            }
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        System.out.println(list.toString());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        return sb.append(bb).toString();
    }
    @Test
    public void test(){
        String order = "cba", s = "abcd";
        String bb=customSortString(order,s);
        System.out.println(bb);
    }
}
