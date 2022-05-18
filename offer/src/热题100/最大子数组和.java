package 热题100;

import org.junit.Test;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(sum<nums[i]){
                sum=nums[i];
            }else {
                sum=sum+nums[i];
            }
            max=Math.max(max,sum);
        }
        return max==Integer.MIN_VALUE?nums[0]:max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1};
        System.out.println(maxSubArray(nums));
    }
}
