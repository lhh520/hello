package testproject;

import org.junit.Test;

import java.util.*;

public class K和数对的最大数目 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int x:set){
            if(x+x==k){
                count+=map.get(x)/2;
                map.remove(x);
            }else {
                if(map.containsKey(k-x)){
                    count=count+Math.min(map.get(x),map.get(k-x));
                    map.remove(k-x);
                    map.remove(x);
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,2,2,3,1,1,4,1};
        System.out.println(maxOperations(nums,4));
    }
}
