package back;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int ret=max;
        for(int i=1;i< nums.length;i++){
            ret+=nums[i];
            if(ret<nums[i]){
                ret=nums[i];
            }
            max=Math.max(max,ret);
        }
        return max;
    }
}
