package backtrace;

public class 最大子数组和 {
    public int maxSubArray(int[] nums){
        int Presum=0;
        int max=Presum;
        for(int i=0;i< nums.length;i++){
            Presum+=nums[i];
            if(Presum<nums[i]){
                Presum=nums[i];
            }
            max=Math.max(max,Presum);
        }
        return max;
    }
}
