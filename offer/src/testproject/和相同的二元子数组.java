package testproject;

import java.util.HashMap;
import java.util.Map;

public class 和相同的二元子数组 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int ret=0;
        for(int num:nums){
            map.put(sum,map.getOrDefault(sum,0)+1);
            sum+=num;
            ret+=map.getOrDefault(sum-goal,0);
        }
        return ret;
    }
}
