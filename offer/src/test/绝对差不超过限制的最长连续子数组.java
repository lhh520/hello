package test;

import org.junit.Test;

import java.util.TreeMap;

public class 绝对差不超过限制的最长连续子数组 {
    public int longestSubarray(int[] nums, int limit) {
        //滑动窗口
        int left=0,right=0;
        TreeMap<Integer,Integer>map=new TreeMap<>();
        int ans=0;
        while (right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.lastKey()-map.firstKey()>limit){
                map.put(nums[left],map.get(nums[left])-1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
    @Test
    public void test(){
        int[] nums=new int[]{8,2,4,7};
        int limit=4;
        System.out.println(longestSubarray(nums,limit));
    }
}
