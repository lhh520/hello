package labuladong;

public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return -1;
        int left=0,right=len-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<nums[right]){//一定有一边是有序的 表明右边是有序的
                 if(target>nums[mid]&&target<=nums[right]){//表明目标值在右边
                     left=mid+1;
                 }else {
                     right=mid-1;
                 }
            }else {//表明左边是有序的
                if(target<nums[mid]&&target>=nums[left]){//左边是有序的，且目标值在左边
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
