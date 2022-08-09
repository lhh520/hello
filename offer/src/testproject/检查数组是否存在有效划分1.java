package testproject;

import org.junit.Test;

public class 检查数组是否存在有效划分1 {
    boolean flag=false;
    public boolean validPartition(int[] nums) {
         backTracking(nums,0);
         return flag;
    }
    private void backTracking(int[]nums, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= nums.length) {
            flag=true;
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            //如果是回文子串，则记录
            if (isPalindrome(nums, startIndex, i)) {
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(nums, i + 1);
        }
    }
    //判断是否是回文串
    private boolean isPalindrome(int[]nums, int startIndex, int end) {
        if(end-startIndex==1){
            if(nums[startIndex]==nums[end]){
                return true;
            }else {
                return false;
            }
        }
        int j=end;
        int i=startIndex;
        if(j-i==2){
            if((nums[i]==nums[i+1]&&nums[i]==nums[i+2])||(nums[i+1]==nums[i]+1&&nums[i+2]==nums[i+1]+1)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,1,2};
        System.out.println(validPartition(nums));
    }
}
