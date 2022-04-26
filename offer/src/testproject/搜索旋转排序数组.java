package testproject;

import org.junit.Test;

public class 搜索旋转排序数组 {
    //nums = [4,5,6,7,0,1,2], target = 0
    public int search(int[] nums, int target) {
        int start=0;
        int left=0;
        int mid=0;
        int right=nums.length-1;
        if(nums.length==1&&nums[0]==target)
            return 0;
        if(nums.length==1&&nums[0]!=target)
            return -1;
        while(left<right){
           mid=(left+right)/2;
           if(nums[mid]==target){
               return mid;
           }
           if(nums[0]<=nums[mid]){
               if(nums[0]<=target&&target<nums[mid]){//目标在左边
                   right=mid-1;
               }else {
                   left=mid+1;
               }
           }else {
               if(nums[mid]<target&&target<=nums[nums.length-1]){
                   left=mid+1;
               }else {
                   right=mid-1;
               }
           }
        }
        return -1;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,5,6,7,0,1,2};
        int target=3;
        System.out.println(search(nums,target));
    }
}
