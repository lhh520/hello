package back;

import org.junit.Test;

public class 分割等和子集 {
    public boolean canPartition(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0)
            return false;
        int n= nums.length;
        int target=sum/2;
        int[]dp=new int[target+1];
        for(int i=0;i<n;i++){//先物品，再背包，背包从大到小
            for(int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
    @Test
    public void test(){
        int[]nu=new int[]{1,5,11,5};
        System.out.println(canPartition(nu));
    }
}
