package labuladong;
import org.junit.Test;

import java.util.*;
public class 和大于等于target的最短子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int len=nums.length;
        int[]Pre=new int[len+1];
        for(int i=1;i<=len;i++){
            Pre[i]=Pre[i-1]+nums[i-1];
        }
        System.out.println(Arrays.toString(Pre));
        int ret=Integer.MAX_VALUE;
        for(int j=len;j>0;j--){
            for(int i=j-1;i>0;i--){
                if(Pre[j]-Pre[i]>=target){
                    ret=Math.min(ret,j-i);
                }
            }
        }
        return ret==Integer.MAX_VALUE?0:ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target,nums));
        //System.out.println(1);
    }
}
