package testproject;

import org.junit.Test;

import java.util.*;

public class 查找用户活跃分钟数 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<logs.length;i++){
            if((map.containsKey(logs[i][0]))&&map.get(logs[i][0])==logs[i][1]){
                continue;
            }
            else{
                map.put(logs[i][0],map.getOrDefault(logs[i][0],0)+1);
            }
        }
        int[]ans=new int[k];
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()<=k){
                ans[entry.getValue()]++;
            }
        }
        System.out.println(map.size());
        return ans;
    }
    @Test
    public void test(){
        int[][]logs=new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}};
        int[]ans=findingUsersActiveMinutes(logs,5);
        System.out.println(Arrays.toString(ans));
    }
}
