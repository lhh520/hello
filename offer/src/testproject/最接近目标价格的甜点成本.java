package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最接近目标价格的甜点成本 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n = baseCosts.length;
        int m = toppingCosts.length;
        int range = 1 << m;
        int[] dp = new int[range];
        for (int i = 0; i < range; i++) {
            int cur = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    cur += toppingCosts[j];
                }
            }
            dp[i] = cur;
        }
        System.out.println(Arrays.toString(dp));//包含了所有的配料组成
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < range; i++) {
                for (int j = 0; j < range; j++) {
                    int t = baseCosts[k] + dp[i] + dp[j];
                    int curDiff = Math.abs(t - target);
                    if (curDiff < diff || (curDiff == diff && t < ans)) {
                        diff = curDiff;
                        ans = t;
                    }
                }
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[]baseCosts =new int[]{1,7};
        int[]toppingCosts =new int[] {3,4};
        int target = 10;
        System.out.println(closestCost(baseCosts,toppingCosts,target));
    }
}
