import org.junit.Test;

public class 最大子数组的和 {
    public int maxSubArray(int[] nums){
        int ret=nums[0];
        int Pre=nums[0];
        for(int i=1;i<nums.length;i++){
            ret=Math.max(Pre,ret);
            Pre+=nums[i];
            if(Pre<nums[i]){
                Pre=nums[i];
            }
            ret=Math.max(Pre,ret);
        }
        return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
