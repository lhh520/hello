package 代码随想录二刷.数组;

public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int slow=1,fast=1;
        int n=nums.length;
        while (fast<n){
            if(nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
