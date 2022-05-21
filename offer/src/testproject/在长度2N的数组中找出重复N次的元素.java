package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 在长度2N的数组中找出重复N次的元素 {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int mid=nums.length/2;
        return nums[mid]==nums[mid+1]?nums[mid]:nums[mid-1];
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,1,2,5,3,2};
        System.out.println(repeatedNTimes(nums));
    }
}
