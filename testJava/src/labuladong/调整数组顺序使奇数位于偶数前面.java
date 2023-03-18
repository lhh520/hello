package labuladong;

import org.junit.Test;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int[]copy=new int[nums.length];
        int odd=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]%2!=0){
                odd++;
            }
        }
        int a=0,b=odd;
        for(int i=0;i< nums.length;i++){
            if(nums[i]%2==0){
                copy[odd++]=nums[i];
            }else {
                copy[a++]=nums[i];
            }
        }
        return copy;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,4,6};
        int[]yy=exchange(nums);
        System.out.println(Arrays.toString(yy));
    }
}
