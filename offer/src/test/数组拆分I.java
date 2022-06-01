package test;

import org.junit.Test;

import java.util.Arrays;

public class 数组拆分I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int min=0;
        while (i<j){
            min=min+Math.min(nums[i],nums[j]);
            i++;
            j--;
        }
        return min;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
}
