package test;

import org.junit.Test;

import java.util.Arrays;

public class test747 {
    public int dominantIndex(int[] nums) {
    if(nums.length==1&&(nums.length==2&&(nums[1]==0||nums[0]==0)))
        return 0;
    int[] temp=nums.clone();
    Arrays.sort(temp);
    int a=temp[temp.length-1];
    int b=temp[temp.length-2];
    boolean flag=false;
    if((b!=0&&a/b>=2)||(a!=0&&b==0))
      flag=true;
    if(flag)

        for (int i = 0; i < nums.length; i++) {
           if(nums[i]==a)
               return i;
        }
        return -1;
    }
    @Test
    public void test()
    {
        int[] nums=new int[]{0,0,0,1};
        System.out.println(dominantIndex(nums));
    }
}
