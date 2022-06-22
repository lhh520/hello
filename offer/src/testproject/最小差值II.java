package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最小差值II {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int res=nums[n-1]-nums[0];
        for(int i=1,x,y;i<nums.length;i++){
            x=Math.min(nums[0]+k,nums[i]-k);//从某一位开始减 最小值 就会在当前值减去k产生
            y=Math.max(nums[n-1]-k,nums[i-1]+k);//从某一位开始，开始加上最小值 ，则最大的一位会在
            res=Math.min(res,y-x);
        }
        return res;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1};
        System.out.println(smallestRangeII(nums,0));
    }
}
