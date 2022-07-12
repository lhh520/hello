package 代码随想录;

import org.junit.Test;

import java.util.Arrays;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum<target){
            return 0;
        }
        int len=nums.length;
        int summ=0;
        int start=0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            summ+=nums[i];
            while (summ>=target){
                int length=i-start+1;
                res=res<length?res:length;
                summ-=nums[start];
                start++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

}
