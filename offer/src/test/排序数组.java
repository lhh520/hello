package test;

import org.junit.Test;

import java.util.Arrays;

public class 排序数组 {
    public int[] sortArray(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums;
    }
    @Test
    public void test(){
        //nums = []
        int[]nums=new int[]{5,2,3,1};
        int[]ans=sortArray(nums);
        System.out.println(Arrays.toString(ans));
    }
}
