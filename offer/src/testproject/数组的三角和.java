package testproject;

public class 数组的三角和 {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        while (--n>=0){
            for(int i=0;i<n;i++){
                nums[i]=(nums[i]+nums[i+1])%10;
            }
        }
        return nums[0];
    }
}
