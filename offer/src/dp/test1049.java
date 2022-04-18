package dp;

import org.junit.Test;

public class test1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i=0;i<stones.length;i++){
            sum=sum+stones[i];
        }
        int target=sum/2;
        int n=stones.length;
        int[]dp=new int[target+1];
        for(int i=0;i<n;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[target]-dp[target];
    }
    @Test
    public void test(){
        int[]stones =new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(stones));
    }
}
