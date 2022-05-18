package 热题100;

import org.junit.Test;

import java.util.*;

public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] cc=strs[i].toCharArray();
            Arrays.sort(cc);
            String temp=new String(cc);
            List<String>list=map.getOrDefault(temp,new ArrayList<String>());
            list.add(strs[i]);
            map.put(temp,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    @Test
    public void test(){
        String[] strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>lists=groupAnagrams(strs);
        System.out.println(lists.toString());
    }
}
