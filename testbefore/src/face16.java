import org.junit.Test;

public class face16 {
    public int massage(int[] nums) {
        int len=nums.length;
        if(len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
    int[]dp=new int[len];
     dp[0]=nums[0];
     dp[1]=Math.max(nums[0],nums[1]);
     for(int i=2;i<len;i++)
     {
         dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
     }
        //System.out.println(dp[len-1]);
     return dp[len-1];
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{2,1,4,5,3,1,1,3};
        System.out.println(massage(nums));
    }
}
