package 代码随想录;

import org.junit.Test;

public class 最后一块石头的重量II {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i=0;i<stones.length;i++){
            sum=sum+stones[i];
        }
        int target=sum/2;
        int[]dp=new int[target+1];
        for(int i=0;i<stones.length;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[target]-dp[target];
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(nums));
    }
}
