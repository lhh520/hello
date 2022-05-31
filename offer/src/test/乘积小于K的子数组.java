package test;

import org.junit.Test;

public class 乘积小于K的子数组 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //滑动窗口
        int i=0,j=0;
        int cur=1;
        int count=0;
        while (j<nums.length){
            cur=cur*nums[j];
            while (cur>=k){
                cur=cur/nums[i];
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
    @Test
    public void test(){
        int[]nums=new int[]{10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums,100));
    }
}
