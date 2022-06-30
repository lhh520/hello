package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 三次操作后最大值与最小值的最小差 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            //nums[n - 4 + i] - nums[i]
            ans=Math.min(ans,nums[n - 4 + i] - nums[i]);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums =new int[]{5,3,2,4};
        System.out.println(minDifference(nums));
    }
}
