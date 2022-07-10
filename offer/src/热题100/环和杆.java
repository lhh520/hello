package 热题100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 环和杆 {
    public int countPoints(String rings) {
        Map<Integer,Set<Character>>map=new HashMap<>();
        for(int i=0;i<rings.length()-1;i+=2){
            char c=rings.charAt(i);
            int num=rings.charAt(i+1)-'0';
            if(!map.containsKey(num)){
                map.put(num,new HashSet<>());
            }
            Set<Character> set=map.get(num);
            set.add(c);
            map.put(num,new HashSet<>(set));
        }
        int count=0;
        for(Map.Entry<Integer,Set<Character>>entry: map.entrySet()){
            if(entry.getValue().size()==3){
                count++;
            }
        }
        return count;
    }
}
