package stack;

public class 移除元素 {
    public int removeElement(int[] nums, int val){
        int slow=0;
        int sz=nums.length;
        for(int fast=0;fast<sz;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

}
