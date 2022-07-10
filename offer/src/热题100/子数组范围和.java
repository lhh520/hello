package 热题100;

public class 子数组范围和 {
    public long subArrayRanges(int[] nums){
        int ret=0;
        for(int i=0;i< nums.length;i++){//一直枚举左边界
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int j=i;j<nums.length;j++){
                min=Math.min(min,nums[j]);
                max=Math.max(max,nums[j]);
                ret+=max-min;
            }
        }
        return ret;
    }
}
