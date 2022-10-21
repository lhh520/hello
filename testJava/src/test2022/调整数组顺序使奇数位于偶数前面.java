package test2022;

import org.junit.Test;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int odd=0,env=0;//奇数 偶数
        for(int i=0;i< nums.length;i++){
            if(nums[i]%2!=0){
                env++;
            }else {
                odd++;
            }
        }
        int[]clone=new int[nums.length];
        int k1=0,k2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                clone[env+k2]=nums[i];
                k2++;
            }else {
                clone[k1]=nums[i];
                k1++;
            }
        }
        return clone;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
