package testproject;

import org.junit.Test;

import java.util.List;

public class 等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int d=nums[0]-nums[1],t=0;
        int ans=0;
        for(int i=2;i<n;i++){
            if(nums[i-1]-nums[i]==d){
                ++t;
            }else {
                d=nums[i-1]-nums[i];
                t=0;
            }
            ans+=t;
        }
        return ans;
    }
    @Test
    public void test(){

    }
}
