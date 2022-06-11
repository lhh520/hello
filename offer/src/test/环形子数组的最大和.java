package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class 环形子数组的最大和 {
    //nums = [1,-2,3,-2]
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for(int i=0;i< nums.length;i++){
            curMax=Math.max(curMax+nums[i],nums[i]);
            maxSum=Math.max(curMax,maxSum);//获取最大和
            curMin=Math.min(curMin+nums[i],nums[i]);
            minSum=Math.min(curMin,minSum);//获取最大和
            total=total+nums[i];
        }
        return maxSum>0?Math.max(maxSum,total-maxSum):minSum;
    }
    @Test
    public void test(){
        int[]nums=new int[]{5,-3,5};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
