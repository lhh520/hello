package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 卡牌分组 {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<deck.length;i++){
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }
        List<Integer>list=new ArrayList<>();
        for(int num: map.values()){
           list.add(num);
        }
        int g=-1;
        Collections.sort(list);
        if(list.get(0)<2){
            return true;
        }
        for(int i=0;i<list.size();i++){
            if(g==-1) g=list.get(i);//从前向后 ，所以list.get(i)一定大于g
            g = gcd(list.get(i), g);
        }
        return g>=2?true:false;
    }
    public int gcd(int x, int y) {//求最大的公约数
        return x == 0 ? y : gcd(y % x, x);
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,1,2,2,2,3,3};
        System.out.println(hasGroupsSizeX(nums));
    }

}
