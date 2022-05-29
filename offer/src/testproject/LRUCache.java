package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    int cap;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.cap=capacity;
    }

    public int get(int key) {
        if(super.containsKey(key)){
            return super.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>cap;
    }
}
