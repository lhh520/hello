package test;

import org.junit.Test;

public class 最大的异或 {
    public int findMaximumXOR(int[] nums) {
        int max=Integer.MIN_VALUE;
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;j<nums.length;j++){
                max=Math.max(max,nums[i]^nums[j]);
            }
        }
        return max;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }
}
