package testproject;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 转化数字的最小运算数 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Deque<Integer>d=new ArrayDeque<>();
        Map<Integer,Integer>map=new HashMap<>();
        d.addLast(start);//先将最后一位入队
        map.put(start,0);
        while (!d.isEmpty()){
            int cur=d.pollFirst();
            int step=map.get(cur);
            for(int i:nums){//表示可选择的
                int[]res=new int[]{cur+i,cur-i,cur^i};
                for(int next:res){
                    if(next==goal){
                        return step+1;
                    }
                    if(next<0||next>1000) continue;
                    if(map.containsKey(next)) continue;//如果已经包含 则必然不可能提供更近的路
                    map.put(next,step+1);
                    d.addLast(next);
                }
            }
        }
        return -1;
    }
}
