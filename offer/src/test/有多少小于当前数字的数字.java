package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[]bucket=new int[100];
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]]++;
        }
        for(int i=1;i<100;i++){
            bucket[i]+=bucket[i-1];
        }
        int[]ret=new int[nums.length];
        for(int i=0;i< nums.length;i++){
            ret[i]=nums[i]==0?0:bucket[nums[i]]-1;
        }
        return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{8,1,2,2,3};
        int[]uu=smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(uu));
    }
}
