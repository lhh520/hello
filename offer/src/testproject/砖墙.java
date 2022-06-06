package testproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 砖墙 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer>map=new HashMap<>();
        //遍历获得所有的缝隙
        for(List<Integer>list:wall){
            int sum=0;
            for(int i=0;i<list.size();i++){
                sum+=list.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for(int nn:map.values()){
            System.out.println(nn);
        }
        int max=0;
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            max=Math.max(max,entry.getValue());
        }
        return wall.size()-max;
    }
}
