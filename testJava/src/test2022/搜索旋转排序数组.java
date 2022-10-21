package test2022;

import org.junit.Test;

public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid]){
                return mid;
            }
            //右边有序
            if(nums[mid]<right){
                //目标值在右边
                if(target>nums[mid]&&target<=nums[right]){
                     left=mid+1;
                }else {
                    right=mid-1;
                }
            }else {//左边有序
                if(target>=nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
        }
        return -1;
    }
    //简单的二分查找
    public int search1(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target) {
                right = mid - 1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,4,5};
        System.out.println(search1(nums,2));
    }
}
