package 新刷题;

import java.util.Arrays;

public class 需要添加的硬币的最小数量 {
    public static int minimumAddedCoins2(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[target] > target ? -1 : dp[target];
    }
    public static int minimumAddedCoins(int[] coins, int target) {
        int[]dp=new int[target+1];
        for(int i=0;i<coins.length;i++){
            dp[coins[i]]=0;
        }
            return 0;
    }
    public static void main(String[] args) {
        int[] coins = {1,4,10};
        int target = 19;
        int result = minimumAddedCoins(coins, target);
        System.out.println(result);
    }
}
