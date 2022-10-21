package backtrace;

import org.junit.Test;

import java.util.Arrays;

public class 快速排序 {
    public void QuickSort(int[]nums,int left,int right){
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
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        int temp=nums[left];
        nums[left]=baseNum;
        nums[left0]=temp;
        QuickSort(nums,left0,left-1);
        QuickSort(nums,left+1,right0);
    }
    //
    public void QuickSort1(int[]nums,int left,int right){
        if(left>right){
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=nums[left];
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
        QuickSort1(nums,left0,left-1);
        QuickSort1(nums,left+1,right0);
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,2,3,32,5};
        QuickSort1(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
