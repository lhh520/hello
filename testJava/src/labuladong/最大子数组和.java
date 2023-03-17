package labuladong;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int ret=nums[0];
        int Pre=nums[0];
        for(int i=1;i< nums.length;i++){
            Pre+=nums[i];
            if(Pre<nums[i]){
                Pre=nums[i];
            }
            ret=Math.max(ret,Pre);
        }
        return ret;
    }
}
