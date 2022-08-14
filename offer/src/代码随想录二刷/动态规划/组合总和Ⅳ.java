package 代码随想录二刷.动态规划;

public class 组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {
        int[]dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.length;i++){
                if(i>=nums[j]){
                    dp[i]=dp[i]+dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public int change(int amount, int[] coins) {
        int[]dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        System.out.print(test1());
    }
    public static int test1() {
        int a = 20;
        try {
            return a + 25;
        } catch (Exception e) {
            System.out.println("test catch exception");
        } finally {
            System.out.print(a + " ");
            a = a + 10;
        }
        return a;
    }
}
