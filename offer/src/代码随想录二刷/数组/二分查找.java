package 代码随想录二刷.数组;

import org.junit.Test;

public class 二分查找 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int left=0;
        int right=len-1;
        while (left<right){
            int mid=(left+right)/2;//取到中间值
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[]nums =new int[]{-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }
}
