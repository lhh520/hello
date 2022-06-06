package testproject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 我的日程安排表III {
    Map<Integer,Integer>map;
    public 我的日程安排表III() {
        map=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);
        int ans=0;
        int temp=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int freq=entry.getValue();
            temp+=freq;
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}
