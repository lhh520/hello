package 新刷题;

import org.junit.Test;

public class 移除重复元素 {
    public int removeElement(int[] nums, int val) {
        int slow=0,fast=0;
        for(fast=0;fast<nums.length;fast++){
            if(nums[fast]==val){
                nums[slow]=nums[fast];
                slow++;
            }

        }
        return slow;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,2,3};
        System.out.println(removeElement(nums,3));
    }
}
