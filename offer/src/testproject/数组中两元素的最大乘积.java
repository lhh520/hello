package testproject;

import java.util.Arrays;

public class 数组中两元素的最大乘积 {
    public int maxProduct(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n= nums.length;
        Arrays.sort(nums);
        return (nums[n-1]-1)*(nums[n-2]-1);
    }
}
