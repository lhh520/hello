package Hot100_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            if(map.containsKey(target-cur)){
                return new int[]{map.get(target-cur),i};
            }
            map.put(cur,i);
        }
        return new int[]{};
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,7,11,15};
        int[]ans=twoSum(nums,9);
        System.out.println(Arrays.toString(ans));
    }
}
