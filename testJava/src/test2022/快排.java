package test2022;

import org.junit.Test;

import java.util.Arrays;

public class 快排 {
    public void Quick(int[]nums,int left,int right){
        if(left>right){
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=nums[left0];
        while (left!=right){
            while (left<right&&nums[right]>=baseNum){
                right--;
            }
            while (left<right&&nums[left]<=baseNum){
                left++;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        int temp=nums[left0];
        nums[left0]=nums[left];
        nums[left]=temp;
        Quick(nums,left0,left-1);
        Quick(nums,left+1,right0);
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,2,4,4};
        Quick(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
