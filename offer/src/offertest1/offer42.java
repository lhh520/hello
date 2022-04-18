package offertest1;

import org.junit.Test;

public class offer42 {
    public int maxSubArray(int[] nums) {
    int res=nums[0];
    for(int i=1;i<nums.length;i++){
        nums[i]=nums[i]+Math.max(nums[i-1],0);
        res=Math.max(res,nums[i]);
    }
    return res;
    }
    public int maxSubArray1(int[] nums){
        int pre=0,maxAns=nums[0];
        for(int x:nums){
            pre=Math.max(pre+x,pre);
            maxAns=Math.max(maxAns,pre);
        }
        return maxAns;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
