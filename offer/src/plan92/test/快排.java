package plan92.test;

import org.junit.Test;

import java.util.Arrays;

public class 快排 {
    public static void quickSort(int[]nums,int left,int right){
        if(left>right){
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=nums[left];
        while (left!=right){
            while (nums[right]>=baseNum&&left<right){
                right--;
            }
            while (nums[left]<=baseNum&&left<right){
                left++;
            }
            //先将中间的进行交换
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        int temp=nums[left];
        nums[left]=baseNum;
        nums[left0]=temp;
        quickSort(nums,left0,left-1);
        quickSort(nums,right+1,right0);
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,3,4,3,3};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
