package dp;

public class 乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int begin=1;
        int n=nums.length;
        int[]Pre=new int[n+1];
        for(int i=1;i<=n;i++){
            Pre[i]=nums[i-1]*Pre[i-1];
        }
    }
}
