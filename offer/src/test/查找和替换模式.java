package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 查找和替换模式 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String>list=new ArrayList<>();
        for(int i=0;i< words.length;i++){
            String cur=words[i];
            if(match(cur,pattern)){
                list.add(cur);
            }
        }
        return list;
    }
    public boolean match(String cur,String pattern){
        Map<Character,Character>map1=new HashMap<>();
        Map<Character,Character>map2=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char k=cur.charAt(i);
            char v=pattern.charAt(i);
            if(!map1.containsKey(k)){
                map1.put(k,v);
            }
            if(!map2.containsKey(v)){
                map2.put(v,k);
            }
            if(map1.get(k)!=v||map2.get(v)!=k){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        String[]words =new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String>list=findAndReplacePattern(words,pattern);
        System.out.println(list.toString());
    }
}
