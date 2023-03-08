package labuladong;

public class 二分查找 {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right=mid;
            }else {
                left=mid;
            }
        }
        return -1;
    }
}
