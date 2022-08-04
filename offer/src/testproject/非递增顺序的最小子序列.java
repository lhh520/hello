package testproject;

import org.junit.Test;

import java.util.*;

public class 非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer>ret=new ArrayList<>();
        int total=Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer>ans=new ArrayList<>();
        int curr=0;
        for(int i=nums.length-1;i>=0;i--){
            curr+=nums[i];
            ans.add(nums[i]);
            if(total-curr<curr){
                break;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,3,10,9,8};
        List<Integer>ans=minSubsequence(nums);
        System.out.println(ans);
    }
}
