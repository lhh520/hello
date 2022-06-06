package testproject;

public class 数组中两个数的最大异或值 {
    public int findMaximumXOR(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                max=Math.max(max,nums[i]^nums[j]);
            }
        }
        return max;
    }
}
