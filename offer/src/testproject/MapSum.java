package testproject;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    /** Initialize your data structure here. */
    Map<String,Integer>map;
    public MapSum() {
        map=new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int ret=0;
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            if(entry.getKey().startsWith(prefix)){
                ret+=entry.getValue();
            }
        }
        return ret;
    }
}
