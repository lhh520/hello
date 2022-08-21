package mei01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class test05 {
    @Test
    public void test(){
         int[]nums=new int[]{1,1,4,5,1,4};
        System.out.println(getmini(nums));
    }
    public int getmini(int[]nums){
        int max=0,min=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        Arrays.sort(nums);
        max=nums[nums.length-1];
        min=nums[nums.length-2];
        if(max==min&&max==nums[0]){
            return nums.length/2;
        }
        int ret1=0;
        boolean flag1=true;
        boolean flag2=true;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                ret1+=(max-nums[i]);
            }else {
                if(nums[i]-min>0){
                    flag1=false;
                    break;
                }
                ret1+=(min-nums[i]);
            }
        }
        int ret2=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                ret2+=(min-nums[i]);
            }else {
                if(nums[i]-min>0){
                    flag2=false;
                    break;
                }
                ret2+=(max-nums[i]);
            }
        }
        if(flag1&&flag2)
        return Math.min(ret1,ret2);
        else {
            if(flag1) return ret1;
            else return ret2;
        }

    }




}
