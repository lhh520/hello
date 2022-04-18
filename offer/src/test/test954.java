package test;

import java.util.*;

public class test954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0));
        }
        if(map.getOrDefault(0,0)%2!=0)
            return false;
        List<Integer> vals=new ArrayList<>();
        for(int u:map.keySet()){
            vals.add(u);
        }
        Collections.sort(vals, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1)-Math.abs(o2);
            }
        });
        for(int x:vals){
            if(map.getOrDefault(2*x,0)<map.get(x))
                return false;
            map.put(2*x,map.getOrDefault(2*x,0)-map.get(x));
        }
        return true;
    }
}
