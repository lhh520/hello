package test;

import org.junit.Test;

import java.util.*;

public class 两句话中的不常见单词 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer>map=new HashMap<>();
        String[]strs1=s1.split(" ");
        String[]strs2=s2.split(" ");
        for(int i=0;i<strs1.length;i++){
            map.put(strs1[i],map.getOrDefault(strs1[i],0)+1);
        }
        for(int i=0;i<strs2.length;i++){
            map.put(strs2[i],map.getOrDefault(strs2[i],0)+1);
        }
        List<String>list=new ArrayList<>();
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        String[]ans=new String[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    @Test
    public void test(){
       String s1 = "this apple is sweet", s2 = "this apple is sour";
       String[]tt=uncommonFromSentences(s1,s2);
        System.out.println(Arrays.toString(tt));
    }
}
