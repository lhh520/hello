package 新刷题;

public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int slow=1,fast=1;//第一个元素一定不重复
        while (fast<nums.length){
           if(nums[fast]!=nums[fast-1]){
               nums[slow]=nums[fast];//已经破坏了原有的数列
               slow++;
           }
           //当nums[fast]==nums[fast-1]时,快指针则一直向下
           fast++;
        }
        return slow;
    }

}
