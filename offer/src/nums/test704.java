package nums;

import org.junit.Test;

public class test704 {
    public int search(int[] nums, int target) {
       int left=0;
       int right=nums.length-1;
       while (left<right){
           int mid=(left+right)/2;
           if(nums[mid]==target)
               return mid;
           if(nums[mid]>target){
               right=mid-1;
           }else {
               left=mid+1;
           }
       }
       return -1;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-1,0,3,5,9,12};
        System.out.println(search(nums,9));
    }
}
