package back;

import org.junit.Test;

public class 目标和 {
    public int findTargetSumWays(int[] nums, int target){
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if((sum+target)%2!=0)
            return 0;
        //System.out.println(1);
        int bagsize=(sum+target)/2;
        if(bagsize<0)
            bagsize=-bagsize;
        int[]dp=new int[bagsize+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=bagsize;j>=nums[i];j--){
                dp[j]=dp[j]+dp[j-nums[i]];
            }
        }
        return dp[bagsize];
    }
    @Test
    public void test(){
        int[]nums =new int[]{100};
        int target = -200;
        System.out.println(findTargetSumWays(nums,target));
    }
}
