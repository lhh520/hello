package testproject;

import org.junit.Test;

public class 乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int prod=1,i=0;
        int res=0;
        for(int j=0;j<nums.length;j++){
            prod=prod*nums[j];
            while (prod>=k&&i<nums.length){
                prod/=nums[i];//开始收缩
                i++;
            }
            res=res+(j-i+1);
        }
        return Math.max(res,0);
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3};
        System.out.println(numSubarrayProductLessThanK(nums,0));
    }
}
