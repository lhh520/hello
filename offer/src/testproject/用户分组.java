package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 用户分组 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>>map=new HashMap<>();
        List<List<Integer>>ret=new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            int cur=groupSizes[i];
            if(!map.containsKey(cur)){
                map.put(cur,new ArrayList<>());
            }
            List<Integer>list=map.get(cur);
            list.add(i);
            if(list.size()>=cur){//已经发生大于等于的情况
                ret.add(new ArrayList<>(list));
                map.remove(cur);
            }

        }
        return ret;
    }
    @Test
    public void test(){
        int[]groupSizes =new int[]{3,3,3,3,3,1,3};
        System.out.println(groupThePeople(groupSizes));
    }
}
