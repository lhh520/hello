package test;

import java.util.Arrays;

public class test961 {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
