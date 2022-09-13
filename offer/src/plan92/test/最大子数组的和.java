package plan92.test;

import org.junit.Test;

public class 最大子数组的和 {
    public int maxSubArray(int[] nums){
        int sum=nums[0];
        int max=sum;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum<nums[i]){
                sum=nums[i];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
    public int maxSubArray1(int[] nums){
        int len=nums.length;
        int[]dp=new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
    }
}
