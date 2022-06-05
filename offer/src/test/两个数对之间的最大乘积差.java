package test;

import org.junit.Test;

import java.util.Arrays;

public class 两个数对之间的最大乘积差 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n-1]*nums[n-2]-nums[0]*nums[1];
    }
    @Test
    public void test(){
        int[]nums =new int[]{5,6,2,7,4};
        System.out.println(maxProductDifference(nums));
    }
}
