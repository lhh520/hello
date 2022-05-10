package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 三角形的最大周长 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i++) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,1,2};
        System.out.println(largestPerimeter(nums));
    }
}
