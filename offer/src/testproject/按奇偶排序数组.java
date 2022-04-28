package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
        int odd=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                odd++;
            }
        }
        //
        int index=0;
        int index0=odd;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                ans[index++]=nums[i];
            }else {
                ans[index0++]=nums[i];
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,1,2,4};
        System.out.println(sortArrayByParity(nums));
    }
}
