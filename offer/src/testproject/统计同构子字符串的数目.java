package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 统计同构子字符串的数目 {
    public int countHomogenous(String s) {
        Map<Character, List<Integer>>map=new HashMap<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,new ArrayList<>());
            }
            int count=0;
            while (i<s.length()&&s.charAt(i)==c){
                count++;
                i++;
            }
            List<Integer>list=map.get(c);
            list.add(count);
            map.put(c,new ArrayList<>(list));
        }
        int sum=0;
        for(Map.Entry<Character,List<Integer>>entry:map.entrySet()){
            List<Integer>list=entry.getValue();
            for(int ii:list){
                int cur=ii;
                for(int j=0;j<cur;j++){
                    sum=(sum+(cur-j))% 1000000007;
                }
            }
        }
        return sum;
    }
    @Test
    public void test(){
        String s="abbcccaa";
        System.out.println(countHomogenous(s));
    }
}
