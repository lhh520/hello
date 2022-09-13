package plan92.test;
import org.junit.Test;

import java.util.*;
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
             if(map.containsKey(target-nums[i])){
                 return new int[]{map.get(target-nums[i]),i};
             }
             map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,7,11,15};
        System.out.println();
    }
}
