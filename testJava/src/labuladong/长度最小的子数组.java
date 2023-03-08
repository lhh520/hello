package labuladong;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        //前缀和数组
        int[]Pre=new int[nums.length+1];
        int len=nums.length;
        for(int i=1;i<=len;i++){
            Pre[i]=Pre[i-1]+nums[i-1];
        }
        //System.out.println(Arrays.toString(Pre));
        int res=Integer.MAX_VALUE;
        for(int j=0;j< nums.length;j++){
            int len1=Integer.MAX_VALUE;
            for(int i=0;i<j;i++){
                int cur=Pre[j]-Pre[i];
                //System.out.println(cur);
                if(cur>=target){
                    len1=Math.min(j-i+1,len1);
                }
            }
            res=Math.min(len1,res);
        }
        return res;
    }
    @Test
    public void test(){
        int target = 7;
        int[]nums =new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }
}
