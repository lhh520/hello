package baidu;
public class SplitArray {
//4 3
//-1 2 -1 3
    public static void main(String[] args) {
        int[] nums = {-1 ,2 ,-1 ,3};
        int k = 3;
        double result = splitArray(nums, k);
        System.out.println(result);
    }

    public static double splitArray(int[] nums, int k) {
        int n = nums.length;
        double[] sums = new double[n + 1];
        double[][] dp = new double[k + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            dp[1][i] = sums[i] / i;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = Double.MAX_VALUE;
                for (int l = i - 1; l < j; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + (sums[j] - sums[l]) / (j - l));
                }
            }
        }

        return dp[k][n];
    }
}

