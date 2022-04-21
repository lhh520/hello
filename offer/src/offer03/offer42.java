package offer03;

public class offer42 {
    public int maxSubArray(int[] nums) {
       int res=nums[0];
       for(int i=0;i<nums.length;i++){
           nums[i]=nums[i]+Math.max(nums[i-1],0);
           res=Math.max(res,nums[i]);
       }
       return  res;
    }
}
