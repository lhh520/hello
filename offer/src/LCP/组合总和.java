package LCP;

public class 组合总和 {
    public int combinationSum4(int[] nums, int target){
        int[]dp=new int[target+1];//表示组成i 的方法的总数
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j]){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
