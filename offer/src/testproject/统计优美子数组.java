package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 统计优美子数组 {
    public int numberOfSubarrays(int[] nums, int k) {
        int len=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int ans=0;
        for(int num:nums){
            sum+=(num&1);
            int cur=sum-k;
            if(map.containsKey(cur)){
                ans+=map.get(cur);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums =new int[]{2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums,k));
    }
}
