package 代码随想录;

import org.junit.Test;

import java.util.Arrays;

public class 目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        if((sum+target)%2==1){
            return 0;
        }
        int len=(sum+target)/2;
        int[]dp=new int[len+1];
        //先遍历物品，再遍历背包
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=len;j>=nums[i];j--){
                dp[j]=dp[j]+dp[j-nums[i]];
            }
        }
        return dp[len];
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
