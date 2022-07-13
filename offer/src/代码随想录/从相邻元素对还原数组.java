package 代码随想录;

import org.junit.Test;

import java.util.*;

public class 从相邻元素对还原数组 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>>map=new HashMap<>();
        for(int[]ad:adjacentPairs){
            map.putIfAbsent(ad[0],new ArrayList<>());
            map.putIfAbsent(ad[1],new ArrayList<>());
            map.get(ad[0]).add(ad[1]);
            map.get(ad[1]).add(ad[0]);
        }
        int n=adjacentPairs.length+1;
        int[]ret=new int[n];
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
             int e=entry.getKey();
             List<Integer>list=entry.getValue();
             if(list.size()==1){//找到第一个左边的
                 ret[0]=e;
                 break;
             }
        }
        ret[1]=map.get(ret[0]).get(0);//表示1
        for(int i=2;i<n;i++){
            List<Integer>list=map.get(ret[i-1]);//得到左和右
            ret[i]=ret[i-2]==list.get(0)?list.get(1):list.get(0);
        }
        return ret;
    }
    @Test
    public void test(){
        int[][]adjacentPairs =new int[][]{{2,1},{3,4},{3,2}};
        int[]ret=restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(ret));
    }
}
