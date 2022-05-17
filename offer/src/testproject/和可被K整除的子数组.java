package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 和可被K整除的子数组 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int ans=0;
        int curnum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            curnum=curnum+nums[i];
            int mod = (curnum % k + k) % k;
            int cc=map.getOrDefault(mod,0);
            ans=ans+cc;
            map.put(mod,cc+1);//又多一个数组
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(nums,5));
    }
}
