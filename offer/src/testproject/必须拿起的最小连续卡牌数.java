package testproject;

import java.util.HashMap;
import java.util.Map;

public class 必须拿起的最小连续卡牌数 {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer>map=new HashMap<>();
        int res=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                res=Math.min(res,i-map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
