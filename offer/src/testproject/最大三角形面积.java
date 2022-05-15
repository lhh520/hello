package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 最大三角形面积 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return null;
    }
    @Test
    public void test(){
        int[]nums =new int[]{2,7,11,15};
        int target = 9;
        int[]nn=twoSum(nums,target);
        System.out.println(Arrays.toString(nn));
    }
}
