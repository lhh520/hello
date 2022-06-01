package test;

import org.junit.Test;

import java.util.*;

public class 变位词组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[]copy= strs.clone();
        HashMap<String,List<String>>map=new HashMap<>();
        for(int i=0;i<copy.length;i++){
            char[] cc=copy[i].toCharArray();
            Arrays.sort(cc);
            copy[i]=String.valueOf(cc);
            String temp=strs[i];
            if(map.containsKey(copy[i])){
                List<String>yy=map.get(copy[i]);
                yy.add(temp);
                map.put(copy[i],yy);
            }else {
                List<String>list=new ArrayList<>();
                list.add(temp);
                map.put(copy[i],new ArrayList<>(list));
            }

        }
        List<List<String>>lists=new ArrayList<>();
        for(Map.Entry<String,List<String>>entry: map.entrySet()){
            lists.add(entry.getValue());
        }

        return lists;
    }
    @Test
    public void test(){
        String[]strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>list=groupAnagrams(strs);
        System.out.println(list.toString());
    }
}
