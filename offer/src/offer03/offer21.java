package offer03;

import org.junit.Test;

import java.util.Arrays;

public class offer21 {
    public int[] exchange(int[] nums) {
        int odd=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]%2!=0){
               odd++;
           }
        }
        int len=nums.length;
        int[]ans=new int[len];
        int m=0,n=0;
        for(int i=0;i<len;i++){
            if(nums[i]%2==0){
                ans[odd+n]=nums[i];
                n++;
            }else {
                ans[m]=nums[i];
                m++;
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,4};
        exchange(nums);
    }
}
