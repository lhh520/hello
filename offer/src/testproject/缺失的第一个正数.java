package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 缺失的第一个正数 {
    //给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
    //
    //请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

    //输入：nums = [1,2,0]
    //输出：3
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while (nums[i]>0&&nums[i]<nums.length&&nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length;
    }
    public void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
}
