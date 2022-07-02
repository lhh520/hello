package testproject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 子串的最大出现次数 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<=s.length()-minSize;i++){
            String str=s.substring(i,i+minSize);
            Set<Character>set=new HashSet<>();
            for(char ch:str.toCharArray()){
                set.add(ch);
            }
            if(set.size()<=maxLetters){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        int ans=0;
        for(String str:map.keySet()){
            ans=Math.max(ans,map.get(str));
        }
        return ans;
    }
}
