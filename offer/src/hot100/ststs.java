package hot100;

import org.junit.Test;

import java.util.Map;

public class ststs {
    public int getMaxSubArray1 (int[] array) {
        int n=array.length;
        int[]dp=new int[n];
        dp[0]=array[0];
        for(int i=1;i<n;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+array[i];
            }else {
                dp[i]=array[i];
            }
        }
        int res=dp[0];
        for(int ii=0;ii< array.length;ii++){
            res= Math.max(res,dp[ii]);
        }
        return res;
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int len=nums.length;
            int[] dp=new int[len];
            dp[0]=nums[0];
            for(int i=1;i<len;i++)
            {
                if(dp[i-1]>0)
                    dp[i]=dp[i-1]+nums[i];
                else
                    dp[i]=nums[i];
            }

            int res=dp[0];
            for(int ii=1;ii<len;ii++)
            {
                res=Math.max(res,dp[ii]);
            }
            return res;

        }
    }
//    public int getMaxSubArray(int[] array){
//        int sum=0;
//        int Max=Integer.MIN_VALUE;
//
//        for(int num:array)
//        {
//            if(sum<0 ||sum== 0)
//            {
//                sum=num;
//            }else
//            {
//                sum+=num;
//            }
//            Max=Math.max(Max,sum);
//        }
//        return Max;
//
//    }






    public int getMaxSubArray2(int[] array) {
        int len=array.length;
        if(len<2){
            return array[0];
        }

        int[] dp=new int[len];
        dp[0]=array[0];
        int maxx=array[0];
        int minx=array[0];
        for(int i=1;i<len;i++)
        {
            if(dp[i-1]>0)
                dp[i]=dp[i-1]+array[i];
            else
                dp[i]=array[i];

            maxx=Math.max(maxx,array[i]);
        }
        if(maxx<0){
            return maxx;
        }


        int res=dp[0];
        for(int ii=0;ii<len;ii++)
        {
            res=Math.max(res,dp[ii]);
        }
        return res;

    }
    public long getMaxSubArray(int[] array) {
        int len=array.length;
        if(len<2){
            return array[0];
        }

        long[] dp=new long[len];
        dp[0]=array[0];
        long maxx=array[0];
        long minx=array[0];
        for(int i=1;i<len;i++)
        {
            if(dp[i-1]>0)
                dp[i]=dp[i-1]+array[i];
            else
                dp[i]=array[i];

            maxx=Math.max(maxx,array[i]);
        }
        if(maxx<0){
            return maxx;
        }


        long res=dp[0];
        for(int ii=0;ii<len;ii++)
        {
            res=Math.max(res,dp[ii]);
        }
        return res;

    }
    @Test
    public void test(){
        //[5,-3,2,-4,8]
        int[]nums=new int[]{5,-3,2,-4,8};
        System.out.println(getMaxSubArray2(nums));
    }
}
