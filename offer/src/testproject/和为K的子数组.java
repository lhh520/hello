package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int len=nums.length;
        int count=0;
        for(int left=0;left<len;left++){
            for(int right=left;right<len;right++){
                int sum=0;
                for(int i=left;i<=right;i++){
                    sum+=nums[i];
                }
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    public int subarraySum1(int[] nums, int k){
        int count=0,pre=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre=pre+nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        System.out.println(subarraySum(nums,3));
    }
}
