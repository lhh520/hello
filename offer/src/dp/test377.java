package dp;

import org.junit.Test;

public class test377 {
    public int combinationSum4(int[] nums, int target) {
    int[]dp=new int[target+1];
    dp[0]=1;
    for(int i=0;i<=target;i++){
        for(int j=0;j<nums.length;j++){
            if(i>=nums[j])
            dp[i]=dp[i]+dp[i-nums[j]];
        }
    }
    return dp[target];
    }
    @Test
    public void test(){
        int[]nums =new int[]{1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums,target));
    }
}
