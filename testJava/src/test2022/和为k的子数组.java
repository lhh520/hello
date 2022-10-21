package test2022;
import org.junit.Test;

import java.util.*;
public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[]PreSum=new int[nums.length+1];
        for(int i=1;i<=n;i++){
            PreSum[i]=PreSum[i-1]+nums[i-1];
        }
        System.out.println(Arrays.toString(PreSum));
        int num=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<= nums.length;i++){
            int cur=PreSum[i];
            if(map.containsKey(cur-k)){
                num+=map.get(cur);
            }
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        return num;
    }

}
